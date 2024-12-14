package solutions.bst_from_array;

import org.junit.Test;
import solutions.bst_from_array.Solution.Node;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void emptyArray() {
        assertNull(s.createBST(null));
        assertNull(s.createBST(new int[]{}));
    }

    @Test
    public void populatedArray() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        Node root = s.createBST(arr);
        assertThat(root, not(nullValue()));
        assertThat(root.value, equalTo(3));

        // left side
        assertThat(root.left.value, equalTo(1));

        assertThat(root.left.left.value, equalTo(0));
        assertThat(root.left.left.left, nullValue());
        assertThat(root.left.left.right, nullValue());

        assertThat(root.left.right.value, equalTo(2));
        assertThat(root.left.right.left, nullValue());
        assertThat(root.left.right.right, nullValue());

        // right side
        assertThat(root.right.value, equalTo(5));

        assertThat(root.right.left.value, equalTo(4));
        assertThat(root.right.left.left, nullValue());
        assertThat(root.right.left.right, nullValue());

        assertThat(root.right.right.value, equalTo(6));
        assertThat(root.right.right.left, nullValue());
        assertThat(root.right.right.right, nullValue());
    }
}
