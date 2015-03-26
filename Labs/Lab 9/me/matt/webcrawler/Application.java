package me.matt.webcrawler;


public class Application {

    public static void main(String[] args) {
        WebCrawler crawler = new WebCrawler("http://google.ca");
        crawler.crawl();
    }

}
