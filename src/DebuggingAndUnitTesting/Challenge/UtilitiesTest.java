package DebuggingAndUnitTesting.Challenge;

import jdk.jshell.execution.Util;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {
    
    private static Utilities util;
    
    @BeforeClass
    public static void setup_beforeClass(){
        util = new Utilities();
    }

    @Test
    public void everyNthChar() {
        char[] output = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[]{'e', 'l'}, output);
        char[] output2 = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @Test
    public void removePairs() {
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertNull("Did not get null returned when argument passed was null", util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
    }

    @Test(expected = ArithmeticException.class)
    public void converter() {
        assertEquals(300, util.converter(10, 5));
        assertEquals(300, util.converter(10, 0));
    }

    @Test(expected = ArithmeticException.class)
    public void converter_arithmeticException() throws Exception {
        util.converter(10, 0);
    }

    @Test
    public void nullIfOddLength() {
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }
}
