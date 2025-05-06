//////////////////////////////////////////////////////////////////// 
// Gianluca Bacco 2111937 
// Leonardo Lorenzin 2116434 
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRomanTest {
    @Test
    public void testConvert() {
        assertEquals("I", IntegerToRoman.convert(1));
        assertEquals("II", IntegerToRoman.convert(2));
        assertEquals("III", IntegerToRoman.convert(3));
	    assertEquals("IV", IntegerToRoman.convert(4));
        assertEquals("V", IntegerToRoman.convert(5));
        assertEquals("VI", IntegerToRoman.convert(6));
        assertEquals("VII", IntegerToRoman.convert(7));
        assertEquals("VIII", IntegerToRoman.convert(8));
        assertEquals("IX", IntegerToRoman.convert(9));
        assertEquals("X", IntegerToRoman.convert(10));
	    assertEquals("XV", IntegerToRoman.convert(15));
        assertEquals("XIX", IntegerToRoman.convert(19));
        assertEquals("XX", IntegerToRoman.convert(20));
        assertEquals("XXX", IntegerToRoman.convert(30));
        assertEquals("XL", IntegerToRoman.convert(40));
        assertEquals("L", IntegerToRoman.convert(50));
	    assertEquals("LX", IntegerToRoman.convert(60));
        assertEquals("LXX", IntegerToRoman.convert(70));
        assertEquals("LXXX", IntegerToRoman.convert(80));
        assertEquals("XC", IntegerToRoman.convert(90));
        assertEquals("C", IntegerToRoman.convert(100));
        assertEquals("CC", IntegerToRoman.convert(200));
        assertEquals("CCC", IntegerToRoman.convert(300));
        assertEquals("CD", IntegerToRoman.convert(400));
        assertEquals("D", IntegerToRoman.convert(500));
	    assertEquals("DC", IntegerToRoman.convert(600));
        assertEquals("DCC", IntegerToRoman.convert(700));
        assertEquals("DCCC", IntegerToRoman.convert(800));
        assertEquals("CM", IntegerToRoman.convert(900));
        assertEquals("M", IntegerToRoman.convert(1000));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConversionZero() {
        IntegerToRoman.convert(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConversionGreaterThan1000() {
        IntegerToRoman.convert(1001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConversionNegative() {
        IntegerToRoman.convert(-1);
    }
    private int romanToInteger(String romanNumeral) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char c = romanNumeral.charAt(i);
            int val = romanValues.getOrDefault(c, -1);
            if (val == -1) {
                throw new IllegalArgumentException("Invalid Roman numeral character: " + c);
            }
            if (val < prevValue) {
                result -= val;
            } else {
                result += val;
            }
            prevValue = val;
        }
        return result;
    }
    @Test(timeout = 1000)
    public void testCrossCheckConversion() {
        for (int i = 1; i <= 1000; i++) {
            String roman = IntegerToRoman.convert(i);
            int backToInteger = romanToInteger(roman);
            assertEquals("Errore nella conversione bidirezionale di " + i, i, backToInteger);
        }
    }

}
