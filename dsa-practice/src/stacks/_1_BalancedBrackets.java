package stacks;

import java.util.Stack;

/**
 * Given a string exp, write a program to examine whether the pairs and the orders of
 * “{“, “}”, “(“, “)”, “[“, “]” are correct in the given expression.
 * Input: exp = “[()]{}{[()()]()}”
 * Output: Balanced
 * Explanation: all the brackets are well-formed
 *
 * Input: exp = “[(])”
 * Output: Not Balanced
 * Explanation: 1 and 4 brackets are not balanced because
 * there is a closing ‘]’ before the closing ‘(‘
 */
public class _1_BalancedBrackets {

    public static void main(String[] args) {
        String input = "[()]{}{[()()]()}";
        System.out.println("Is the given input string balanced :" + checkStringIsBalanced(input));
    }

    //TC is O(N)
    //SC is O(N)
    private static boolean checkStringIsBalanced(String input) {
        char[] arr = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : arr) {
            if (isOpeningBracket(ch)) {
                stack.push(ch);
            } else {
                //means it is a closing bracket
                if (!stack.isEmpty() && stack.peek() == inverseCharacter(ch)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isOpeningBracket(char ch) {
        switch (ch) {
            case '[' :
            case '{' :
            case '(' :
                return true;
            default  : return false;
        }
    }

    private static Character inverseCharacter(char ch) {
        switch (ch) {
            case '(' : return ')';
            case '{' : return '}';
            case '[' : return ']';
            case ')' : return '(';
            case '}' : return '{';
            case ']' : return '[';
        }
        return '-';
    }
}
