package solutions.plus_one;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each
 * element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * ==========
 * Input: [1, 2, 3]
 * Output: [1, 2, 4]
 *
 * Explanation: The array represents the integer 123.
 *
 *
 * Example 2:
 * ==========
 * Input: [1, 2, 9]
 * Output: [1, 3, 0]
 *
 * Explanation: The array represents the integer 139.
 *
 *
 * Example 3:
 * ==========
 * Input: [9, 9, 9]
 * Output: [1, 0, 0, 0]
 *
 * Explanation: The array represents the integer 999.
 *
 * @author Alex Martins
 */
public class Solution {

    public int[] plusOne(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int toAdd = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int sum = arr[i] + toAdd;
            toAdd = sum >= 10 ? 1 : 0;
            arr[i] = sum % 10;
        }

        if (toAdd == 1) {
            int[] res = new int[arr.length + 1];
            System.arraycopy(arr, 0, res, 1, arr.length);
            res[0] = toAdd;
            return res;
        }

        return arr;
    }
}
