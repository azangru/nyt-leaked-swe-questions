package challenges.is_binary_search_tree;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 *
 * Input:
 *               3
 *             /  \
 *           1     5
 *          / \   / \
 *         0   2 4   6
 *
 * Output: true
 *
 *
 * Input:
 *               3
 *             /  \
 *           4     1
 *          / \   / \
 *         6   0 5   2
 *
 * Output: false
 *
 */
public class Solution {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            return "[" + value + "]";
        }
    }

    public boolean isValidBST(Node root) {
        return false;
    }
}
