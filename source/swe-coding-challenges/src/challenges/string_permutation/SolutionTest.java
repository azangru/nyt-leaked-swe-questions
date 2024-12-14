package challenges.string_permutation;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void differentSizes() {
        assertFalse(s.isPermutation("doggy", "god"));
    }

    @Test
    public void validPermutation() {
        assertTrue(s.isPermutation("dog", "god"));
    }

    @Test
    public void invalidPermutation() {
        assertFalse(s.isPermutation("dig", "god"));
    }

    @Test
    public void emptyString() {
        assertTrue(s.isPermutation("", ""));
    }
}
