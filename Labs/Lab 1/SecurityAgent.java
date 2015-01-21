public class SecurityAgent {

    private final Combination combination;
    private final DoorLock doorlock;

    public SecurityAgent() {
        this.combination = new Combination((int) (Math.random() * 5) + 1,
                (int) (Math.random() * 5) + 1, (int) (Math.random() * 5) + 1);
        this.doorlock = new DoorLock(this.combination);
    }

    public DoorLock getDoorLock() {
        return doorlock;
    }

    public void activateDoorLock() {
        doorlock.activate(combination);
    }

}