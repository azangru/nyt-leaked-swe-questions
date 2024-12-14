import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * calculateGCD takes two integers and returns the greatest common divisor
 * it is currently stubbed out and the unit test is failing
 * please fill in some code to make the test pass, and then add some more unit tests
 *
 * submitted by ben.solwitz@nytimes.com
 */
public class GreatestCommonDivisor {
    public int calculateGCD(int a, int b) {
        return 1;
    }

    @Test
    public void gcdOf8And2Is2() {
        int gcd = calculateGCD(8, 2);
        assertEquals("gcd of 8 and 2 is 2", 2, gcd);
    }
}
