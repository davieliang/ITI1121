package me.matt.webcrawler;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedTransferQueue;

import me.matt.webcrawler.workers.LinkVisitor;
import me.matt.webcrawler.wrappers.Path;

public class WebCrawler {

    private final Collection<Path> links = Collections
            .synchronizedCollection(new LinkedTransferQueue<>());

    private ForkJoinPool tasks;
    private String url;

    public WebCrawler(String url) {
        this.url = url;
        tasks = new ForkJoinPool(64);
    }

    public void crawl() {
        tasks.invoke(new LinkVisitor(this, new Path(null, url)));
    }

    public boolean hasVisited(String url) {
        return links.stream().filter(n -> (n.getChild() == url)).count() > 0;
    }

    public void addVisited(Path node) {
        links.add(node);
    }

    public Collection<Path> getLinks() {
        return links;
    }

}
