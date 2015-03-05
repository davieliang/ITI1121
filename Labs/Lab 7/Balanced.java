/**
 * ITI 1121. Introduction à l'informatique II (Hiver 2008).
 * ITI 1521. Introduction to Computer Science II (Winter 2008).
 *
 * @author Marcel Turcotte, Université d'Ottawa/University of Ottawa
 */

public class Balanced {

    public static boolean isBalanced(String s) {
        ArrayStack<Character> stack = new ArrayStack<Character>(s.length());
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (!stack.isEmpty()) {
                    char ch = stack.pop();
                    if ((ch == '(' && c == ')') || (ch == '{' && c == '}')
                            || (ch == '{' && c == '}')) {
                        continue;
                    }
                }
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test = "(({}))";
        System.out.println("The string " + test + " is balanced: " + isBalanced(test));
    }
}