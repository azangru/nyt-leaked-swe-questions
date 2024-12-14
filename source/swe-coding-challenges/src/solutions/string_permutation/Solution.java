package solutions.string_permutation;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 *
 * Case sensitive. White space is significant.
 *
 * Example 1:
 * Input: god, dog
 * Output: True
 *
 * Example 2:
 * Input: god, dig
 * Output: False
 *
 * @author Alex Martins
 */
public class Solution {

    public boolean isPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;

        int[] chars = new int[256]; // assuming ASCII

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            chars[c]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (--chars[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
