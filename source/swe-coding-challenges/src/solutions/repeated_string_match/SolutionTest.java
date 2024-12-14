package solutions.repeated_string_match;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    private Solution s = new Solution();

    @Test
    public void validMatch() {
        assertThat(s.repeatedStringMatch("abcd", "cdabcdab"), equalTo(3));
    }

    @Test
    public void emptyAMatch() {
        assertThat(s.repeatedStringMatch("", "cdabcdab"), equalTo(-1));
        assertThat(s.repeatedStringMatch(null, "cdabcdab"), equalTo(-1));
    }

    @Test
    public void emptyBMatch() {
        assertThat(s.repeatedStringMatch("abcd", ""), equalTo(1));
        assertThat(s.repeatedStringMatch("abcd", null), equalTo(1));
    }

    @Test
    public void invalidMatch() {
        assertThat(s.repeatedStringMatch("abcd", "cdabbbcdab"), equalTo(-1));
    }
}
