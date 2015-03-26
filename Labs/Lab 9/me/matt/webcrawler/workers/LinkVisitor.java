package me.matt.webcrawler.workers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

import me.matt.webcrawler.WebCrawler;
import me.matt.webcrawler.wrappers.HTML;
import me.matt.webcrawler.wrappers.Path;

/**
 *
 * @author Matt Langlois
 */
public class LinkVisitor extends RecursiveAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Path parent;
    private WebCrawler crawler;

    public LinkVisitor(WebCrawler crawler, Path parent) {
        this.parent = parent;
        this.crawler = crawler;
    }

    @Override
    public void compute() {
        if (!crawler.hasVisited(parent.getChild())) {
            try {
                HTML page = new HTML(parent.getChild());

                List<LinkVisitor> actions = new ArrayList<>();
                while (page.hasMoreURLs()) {
                    actions.add(new LinkVisitor(crawler, new Path(parent, page
                            .nextURL())));
                }

                crawler.addVisited(new Path(parent.getParent(), parent
                        .getChild()));

                if (!actions.isEmpty()) {
                    invokeAll(actions);
                }
            } catch (Exception e) {
            }
        }
    }
}