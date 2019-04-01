/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojunit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Unkno
 */
public class DemoJUnitTest {
    private DemoJUnit demoJUnit = new DemoJUnit();
    private static final double DELTA = 1e-15;
    
    public DemoJUnitTest() {
    }
    
    @Test
    public void testDecode1() {
        int[] actuals = demoJUnit.decode("27.");
        int[] expecteds = {27, 27};
        assertEquals(3, actuals.length);
        assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void testDecode2() {
        int[] actuals = demoJUnit.decode("27+");
        int[] expecteds = {27, 28};
        assertEquals(3, actuals.length);
        assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void testDecode3() {
        int[] actuals = demoJUnit.decode("27-");
        int[] expecteds = {27, 26};
        assertEquals(3, actuals.length);
        assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void testDecode4() {
        int[] actuals = demoJUnit.decode("");
        assertEquals(0, actuals.length);
        int[] expecteds = {};
        assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void testDecode5() {
        int[] actuals = demoJUnit.decode("27");
        assertEquals(1, actuals.length);
        int[] expecteds = {27};
        assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void testFindMedian1() {
        Double median = demoJUnit.findMedian("27");
        assertNotNull(median);
        assertEquals(27, median, DELTA);
    }
    
    @Test
    public void testFindMedian2() {
        Double median = demoJUnit.findMedian("12+");
        assertNotNull(median);
        assertEquals(2.5, median, DELTA);
    }
    
    @Test
    public void testFindMedian3() {
        Double median = demoJUnit.findMedian("100+-");
        assertNotNull(median);
        assertEquals(97.5, median, DELTA);
    }
    
    @Test
    public void testFindMedian4() {
        Double median = demoJUnit.findMedian("19+.+");
        assertNotNull(median);
        assertEquals(19, median, DELTA);
    }
    @Test
    public void testFindMedian5() {
        Double median = demoJUnit.findMedian("");
        assertNull(median);
    }
    
    @Test
    public void testFindMedian6() {
        Double median = demoJUnit.findMedian("100--0--");
        assertNull(median);
    }
}
