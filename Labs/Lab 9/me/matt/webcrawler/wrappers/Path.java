package me.matt.webcrawler.wrappers;

public class Path {
    
    private Path parent;
    private String child;

    public Path(Path parent, String child) {
        this.parent = parent;
        this.child = child;
    }
    
    public Path getParent() {
        return parent;
    }
    
    public String getChild() {
        return child;
    }

}
