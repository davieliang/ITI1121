public class Util2 {

    public static boolean isIncreasing(final Time2[] times) {
        for (int i = 0; i < times.length - 1; i++) {
            if (times[i] != null && times[i + 1] != null) {
                if (times[i].before(times[i + 1])) {
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    public static void main(final String[] args) {
        if (args.length != 3) {
            System.out.println("Error, not enough args.");
            return;
        }
        final Time2[] times = new Time2[5];
        times[0] = new Time2(Integer.parseInt(args[0]),
                Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        System.out.println(times[0].toString());
        for (int i = 1; i < times.length; i++) {
            times[i] = times[i - 1].plus(times[0]);
            System.out.println(times[i].toString());
        }
        System.out.println(Util2.isIncreasing(times));

    }
}
