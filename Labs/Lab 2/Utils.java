public class Utils {

    public static String[] findAndReplace(final String[] in,
            final String[] what, final String[] with) {
        if (in == null || what == null || with == null
                || what.length != with.length) {
            return null;
        }
        final String[] copy = in.clone();
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < what.length; j++) {
                if (copy[i] == null || what[j] == null || with[j] == null) {
                    return null;
                }
                if (copy[i].equals(what[j])) {
                    copy[i] = with[j];
                    break;
                }
            }
        }
        return copy;
    }

}
