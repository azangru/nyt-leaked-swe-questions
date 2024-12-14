import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * doesListContainTwoSummands takes a list of integers and a target integer, and returns true if the list contains two numbers which sum to the target
 * it is currently stubbed out and the unit test is failing
 * please fill in some code to make the test pass, and then add some more unit tests
 *
 * submitted by ben.solwitz@nytimes.com
 */
public class TwoSummands {
    public boolean doesListContainTwoSummands(List<Integer> summands, int target) {
        return false;
    }

    @Test
    public void onePlusOneEqualsTwo() {
        boolean listContainsTwoSummands = doesListContainTwoSummands(Arrays.asList(1, 1), 2);
        assertEquals("should return true, 1 + 1 = 2", true, listContainsTwoSummands);
    }
}
