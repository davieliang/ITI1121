public class Test {

    public static void main(final String[] args) {
        final MediaDocument[] mds = new MediaDocument[] {
                new Movie("Superman", "Matt", 125, 8, 7),
                new Audio("Bad", "David Guetta", 5, 10),
                new Movie("Hulk", "Dan", 35, 3, 5),
                new Audio("Summer", "Calvin Harris", 3, 8) };
        int sum = 0;
        for (final MediaDocument md : mds) {
            System.out.println(md.toString());
            sum += md.getRating();
        }
        System.out
                .println("The avrage rating was " + (double) sum / mds.length);
    }

}
