public abstract class MediaDocument extends Document {

    private final int duration;

    public MediaDocument(final String name, final String owner,
            final int duration) {
        super(name, owner);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public abstract int getRating();

}
