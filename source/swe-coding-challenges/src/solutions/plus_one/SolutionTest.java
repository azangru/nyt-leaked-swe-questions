package solutions.plus_one;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void testOneEmpty() {
        int[] a = {};
        int[] e = {};
        assertThat(s.plusOne(a), equalTo(e));
    }

    @Test
    public void testOneNotCarrying() {
        int[] a = {1, 2, 3};
        int[] e = {1, 2, 4};
        assertThat(s.plusOne(a), equalTo(e));
    }

    @Test
    public void testOneCarrying() {
        int[] a = {1, 2, 9};
        int[] e = {1, 3, 0};
        assertThat(s.plusOne(a), equalTo(e));
    }

    @Test
    public void testOneCarryIncreasing() {
        int[] a = {9, 9, 9};
        int[] e = {1, 0, 0, 0};
        assertThat(s.plusOne(a), equalTo(e));
    }
}
