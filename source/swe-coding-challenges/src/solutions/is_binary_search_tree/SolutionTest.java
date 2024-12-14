package solutions.is_binary_search_tree;

import org.junit.Test;
import solutions.is_binary_search_tree.Solution.Node;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void validBinarySearchTree() {
        Node root = new Node(3);
        // left side
        root.left = new Node(1);
        root.left.left = new Node(0);
        root.left.right = new Node(2);
        // right side
        root.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(6);

        assertTrue("Should be a valid binary search tree", s.isValidBST(root));
    }

    @Test
    public void invalidBinarySearchTree() {
        Node root = new Node(3);
        // left side
        root.left = new Node(4);
        root.left.left = new Node(6);
        root.left.right = new Node(0);
        // right side
        root.right = new Node(1);
        root.right.left = new Node(5);
        root.right.right = new Node(2);

        assertFalse("Should NOT be a valid binary search tree", s.isValidBST(root));
    }
}
