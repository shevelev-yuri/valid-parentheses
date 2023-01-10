import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    public static String findValidParentheses(final String input) {
        var buffer = new char[input.length()];
        var string = input.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < string.length; i++) {
            if (string[i] == '(') {
                stack.push(string[i]);
                buffer[i] = string[i];
            }
            if (string[i] == ')') {
                if (!stack.isEmpty() && stack.pop().equals('(')) {
                    buffer[i] = string[i];
                }
            }
        }
        var result = new String(buffer).trim();

        while (!stack.isEmpty()) {
            stack.pop();
            result = result.replaceFirst("[(]", "");
        }
        return result.length() != 0 ?
                result.length() + " - " + result :
                "0";
    }


    public static void main(String[] args) {
        String str1 = "(()";
        String str2 = ")()())";
        String str3 = ")(()())";
        String str4 = ")(";
        System.out.println(findValidParentheses(str1));
        System.out.println(findValidParentheses(str2));
        System.out.println(findValidParentheses(str3));
        System.out.println(findValidParentheses(str4));
    }
}