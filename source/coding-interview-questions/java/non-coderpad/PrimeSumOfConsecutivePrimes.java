import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The prime 41, can be written as the sum of six consecutive primes:
 *                        41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 *
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 *
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
public class PrimeSumOfConsecutivePrimes {
    public int primeSumOfConsecutivePrimes(int max) {
        return 0;
    }

    @Test
    public void primeSumOfConsecutivePrimesLessThan1000000() {
        int primeSumOfConsecutivePrimes = primeSumOfConsecutivePrimes(1000000);
        assertEquals(997651, primeSumOfConsecutivePrimes);
    }
}