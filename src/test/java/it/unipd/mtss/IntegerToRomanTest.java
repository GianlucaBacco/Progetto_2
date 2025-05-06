//////////////////////////////////////////////////////////////////// 
// Gianluca Bacco 2111937 
// Leonardo Lorenzin 2116434 
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class IntegerToRomanTest {
    @Test
    public void testConvert() {
        assertEquals("I", IntegerToRoman.convert(1));
        assertEquals("II", IntegerToRoman.convert(2));
        assertEquals("III", IntegerToRoman.convert(3));
    }
}
