import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * largestPrimeFactor takes an integer and returns the largest prime factor
 * it is currently stubbed out and the unit test is failing
 * please fill in some code to make the test pass, and then add some more unit tests
 *
 * submitted by ben.solwitz@nytimes.com
 */
public class LargestPrimeFactor {
    public int largestPrimeFactor(int target) {
        return 0;
    }

    @Test
    public void largestPrimeFactorOf7667Is41() {
        int largestPrimeFactor = largestPrimeFactor(7667);
        assertEquals("largest prime factor of 7667 is 41", 41, largestPrimeFactor);
    }
}
