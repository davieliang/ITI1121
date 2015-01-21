public class L1Q4 {

    public static void main(String[] args) {
        int sum = 0;
        for (String arg : args) {
            try {
                sum += Integer.parseInt(arg);
            } catch (Exception e) {
                System.out
                        .println(arg
                                + " cannot be represented as an integer, and will therefore not be in the final sum.");
            }
        }
        System.out.println("Your sum is: " + sum);
    }

}
