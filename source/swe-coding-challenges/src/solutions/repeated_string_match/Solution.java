package solutions.repeated_string_match;

/**
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it.
 * If no such solution, return -1.
 *
 * For example, with A = "abcd" and B = "cdabcdab".
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A
 * repeated two times ("abcdabcd").
 *
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (A == null || A.length() == 0) {
            return -1;
        }

        int count = 1;

        if (B == null || B.length() == 0) {
            return count;
        }

        StringBuffer sb = new StringBuffer(A);

        while (sb.length() < B.length()) {
            count++;
            sb.append(A);
        }

        if (sb.indexOf(B) != -1) {
            return count;
        } else {
            count++;
            sb.append(A);
            return sb.indexOf(B) != -1 ? count : -1;
        }
    }
}
