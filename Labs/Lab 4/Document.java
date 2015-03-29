public class Document {

    private static int current = 100;

    private final String name;

    private String owner;

    private final int id;

    public Document(final String name, final String owner) {
        this.name = name;
        this.owner = owner;
        id = Document.current++;
    }

    public void changeOwner(final String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Document)) {
            return false;
        }
        return ((Document) object).getIndexNumber() == this.getIndexNumber();
    }

    public int getIndexNumber() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "{ Name: " + this.getName() + " Owner: " + this.getOwner()
                + " ID: " + this.getIndexNumber() + "}";
    }
}
