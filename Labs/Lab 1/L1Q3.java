import java.util.Arrays;

public class L1Q3 {

    public static void main(final String[] args) {
        Arrays.stream(args).forEachOrdered(
                arg -> System.out.println("Your argument is: " + arg));
    }

}
