package challenges.valid_parentheses;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesesMixedTest {

    ValidParenthesesMixed s = new ValidParenthesesMixed();

    @Test
    public void emptyString() {
        assertTrue("Should be valid when empty or null", s.isValid(""));
        assertTrue("Should be valid when empty or null", s.isValid(null));
    }

    @Test
    public void validScenarios() {
        assertTrue("'()' should be valid", s.isValid("()"));
        assertTrue("'()[]{}' should be valid", s.isValid("()[]{}"));
        assertTrue("'{[()()][{}]}' should be valid", s.isValid("{[()()][{}]}"));
    }

    @Test
    public void invalidScenarios() {
        assertFalse("']' should be invalid", s.isValid("]"));
        assertFalse("'{' should be invalid", s.isValid("{"));
        assertFalse("'][' should be invalid", s.isValid("]["));
        assertFalse("'(]' should be invalid", s.isValid("(]"));
        assertFalse("'([)]' should be invalid", s.isValid("([)]"));
        assertFalse("'([)){[])' should be invalid", s.isValid("([)){[])"));
    }
}
