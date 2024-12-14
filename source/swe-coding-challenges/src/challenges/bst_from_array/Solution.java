package challenges.bst_from_array;

/**
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height.
 *
 * Input: [0, 1, 2, 3, 4, 5, 6]
 * Output:
 *               3
 *             /  \
 *           1     5
 *          / \   / \
 *         0   2 4   6
 *
 * @author Alex Martins
 */
public class Solution {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }

        public String toString() {
            return "[" + value + "]";
        }
    }

    public Node createBST(int[] arr) {
        return null;
    }
}
