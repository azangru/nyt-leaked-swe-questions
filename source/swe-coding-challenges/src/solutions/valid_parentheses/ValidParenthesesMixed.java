package solutions.valid_parentheses;

import java.util.*;

/**
 * Given a string containing just the characters?'(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 *
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()", Output: true
 *
 * Example 2:
 * Input: "()[]{}", Output: true
 *
 * Example 3:
 * Input: "(]", Output: false
 *
 * Example 4:
 * Input: "([)]", Output: false
 *
 * Example 5:
 * Input: "{[]}", Output: true
 *
 * @author Alex Martins
 */
public class ValidParenthesesMixed {

    private Map<Character, Character> variations = new HashMap<Character, Character>() {{
        put('(', ')');
        put('[', ']');
        put('{', '}');
    }};

    public boolean isValid(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // is the current char opening?
            if (variations.containsKey(c)) {
                stack.push(c);

            } else {
                if (stack.isEmpty() || variations.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
