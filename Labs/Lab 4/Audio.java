public class Audio extends MediaDocument {

    private final int rating;

    public Audio(final String name, final String owner, final int duration,
            final int rating) {
        super(name, owner, duration);
        this.rating = rating;
    }

    @Override
    public int getRating() {
        return rating;
    }

}
