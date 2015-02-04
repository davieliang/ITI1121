public class SecurityAgent {

    private final Combination combination;
    private final DoorLock doorlock;

    public SecurityAgent() {
        combination = new Combination((int) (Math.random() * 5) + 1,
                (int) (Math.random() * 5) + 1, (int) (Math.random() * 5) + 1);
        doorlock = new DoorLock(combination);
    }

    public void activateDoorLock() {
        doorlock.activate(combination);
    }

    public DoorLock getDoorLock() {
        return doorlock;
    }

}