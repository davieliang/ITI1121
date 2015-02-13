public class Movie extends MediaDocument {

    private final int acting;

    private final int story;

    public Movie(final String name, final String owner, final int duration,
            final int story, final int acting) {
        super(name, owner, duration);
        this.story = story;
        this.acting = acting;
    }

    public int getActingRating() {
        return acting;
    }

    @Override
    public int getRating() {
        return (int) Math.round((acting + story) / 2D);
    }

    public int getStoryRating() {
        return story;
    }

}
