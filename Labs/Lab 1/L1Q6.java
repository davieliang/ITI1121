public class L1Q6 {

    public static void main(final String[] args) {
        final DoorLock dl = new DoorLock(new Combination(1, 2, 3));

        dl.open(new Combination(3, 2, 1));
        dl.open(new Combination(3, 2, 1));
        dl.open(new Combination(3, 2, 1));

        System.out.println("Door is active: " + dl.isActivated());
        System.out.println("Door is closed: " + dl.isClosed());

        dl.open(new Combination(1, 2, 3));

        System.out.println("Door is active: " + dl.isActivated());
        System.out.println("Door is closed: " + dl.isClosed());

        dl.activate(new Combination(1, 2, 3));

        System.out.println("Door is active: " + dl.isActivated());
        System.out.println("Door is closed: " + dl.isClosed());

        dl.open(new Combination(1, 2, 3));

        System.out.println("Door is active: " + dl.isActivated());
        System.out.println("Door is closed: " + dl.isClosed());

    }

    public static final int MAX_NUMBER_OF_ATTEMPTS = 3;

}
