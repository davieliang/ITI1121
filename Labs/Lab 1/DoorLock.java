public class DoorLock {

    private final Combination combination;
    private int attempts = 0;
    private boolean closed = true, activated = true;

    public DoorLock(final Combination combination) {
        this.combination = combination;
    }

    public boolean isClosed() {
        return closed;
    }

    public boolean isActivated() {
        return activated;
    }

    public void activate(Combination c) {
        if (!activated && c.equals(combination)) {
            activated = true;
            attempts = 0;
        }
    }

    public boolean open(Combination c) {
        if (isActivated() && isClosed()
                && attempts < L1Q6.MAX_NUMBER_OF_ATTEMPTS) {
            if (c.equals(combination)) {
                attempts = 0;
                closed = false;
                return true;
            }
            attempts++;
            return false;
        }
        activated = false;
        return false;
    }

}