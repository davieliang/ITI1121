public class DoorLock {

    private final Combination combination;
    private int attempts = 0;
    private boolean closed = true, activated = true;

    public DoorLock(final Combination combination) {
        this.combination = combination;
    }

    public void activate(final Combination c) {
        if (!activated && c.equals(combination)) {
            activated = true;
            attempts = 0;
        }
    }

    public boolean isActivated() {
        return activated;
    }

    public boolean isClosed() {
        return closed;
    }

    public boolean open(final Combination c) {
        if (this.isActivated() && this.isClosed()
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