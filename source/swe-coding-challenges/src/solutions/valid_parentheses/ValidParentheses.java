package solutions.valid_parentheses;

/**
 * Given a string containing just the characters '(' and ')', determine if the input string is valid.
 *
 * An input string is valid if:
 * 1. Open parentheses must be closed in the correct order.
 *
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()", Output: true
 *
 * Example 2:
 * Input: "())", Output: False
 *
 * Example 3:
 * Input: "(", Output: False
 *
 * Example 4:
 * Input: "()()()", Output: True
 *
 * Example 5:
 * Input: "(()((())))", Output: True
 *
 * Example 6:
 * Input: ")(", Output: False
 *
 * @author Alex Martins
 *
 */
public class ValidParentheses {

    public boolean isValid(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        int totalOpen = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                totalOpen++;
            } else {
                if (totalOpen == 0) {
                    return false;
                } else {
                    totalOpen--;
                }
            }
        }
        return totalOpen == 0;
    }
}
