package c0ValidParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效圆括号
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if ((stack.peek() == '[' && s.charAt(i) == ']') ||
                    (stack.peek() == '(' && s.charAt(i) == ')') ||
                    (stack.peek() == '{' && s.charAt(i) == '}')
            ) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty() ? true : false;


    }

    /**
     * 网上解法
     */
    public boolean isValid1(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') stack.push('}');
            else if (s.charAt(i) == '[') stack.push(']');
            else if (s.charAt(i) == '(') stack.push(')');
            else {
                if (stack.isEmpty() || stack.pop() != s.charAt(i)) return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        ValidParentheses parentheses = new ValidParentheses();
        System.out.println(parentheses.isValid1("[({})]"));
    }
}
