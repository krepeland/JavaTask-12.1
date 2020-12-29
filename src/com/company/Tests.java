package com.company;
import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

    @Test(expected = NullPointerException.class)
    public void testNull() {
        Integer.decode(null);
    }

    @Test(expected = NumberFormatException.class)
    public void testEmptyString() {
        Integer.decode("");
    }

    @Test
    public void testNegativeSign(){
        assertEquals(-100, (int) Integer.decode("-100"));
    }

    @Test
    public void testPositiveSign() {
        assertEquals(100, (int) Integer.decode("100"));
        assertEquals(100, (int) Integer.decode("+100"));
    }

    @Test
    public void testZero() {
        assertEquals(0, (int) Integer.decode("0"));
    }

    @Test
    public void testPositiveHex(){
        assertEquals(256, (int) Integer.decode("0X100"));
        assertEquals(1978, (int) Integer.decode("0X7ba"));
        assertEquals(4095, (int) Integer.decode("0xfff"));
        assertEquals(2577, (int) Integer.decode("#a11"));
    }

    @Test
    public void testNegativeHex(){
        assertEquals(-256, (int) Integer.decode("-0X100"));
        assertEquals(-1978, (int) Integer.decode("-0X7ba"));
        assertEquals(-4095, (int) Integer.decode("-0xfff"));
        assertEquals(-2577, (int) Integer.decode("-#a11"));
    }

    @Test
    public void testPositiveOct() {
        assertEquals(12, (int) Integer.decode("014"));
        assertEquals(63, (int) Integer.decode("077"));
        assertEquals(64, (int) Integer.decode("0100"));
        assertEquals(511, (int) Integer.decode("0777"));
    }

    @Test
    public void testNegativeOct() {
        assertEquals(-12, (int) Integer.decode("-014"));
        assertEquals(-63, (int) Integer.decode("-077"));
        assertEquals(-64, (int) Integer.decode("-0100"));
        assertEquals(-511, (int) Integer.decode("-0777"));
    }

    @Test(expected = NumberFormatException.class)
    public void testSpace() {
        Integer.decode("- 100");
        Integer.decode(" 100");
        Integer.decode("21 343");
        Integer.decode("0x f1");
        Integer.decode("# f1");
        Integer.decode("0 111");
    }

    @Test
    public void testIntegerMinValue() {
        assertEquals(Integer.MIN_VALUE, (long) Integer.decode(Integer.toString(Integer.MIN_VALUE)));
    }

    @Test
    public void testIntegerMaxValue() {
        assertEquals(Integer.MAX_VALUE, (long) Integer.decode(Integer.toString(Integer.MAX_VALUE)));
    }

    @Test(expected = NumberFormatException.class)
    public void testLong() {
        Integer.decode(Long.toString((long) Integer.MIN_VALUE - 1));
        Integer.decode(Long.toString((long) Integer.MAX_VALUE + 1));
    }
}
