import org.junit.Assert;
import org.junit.Test;

import static vadim.Main.calcString;
import static vadim.Main.calculate;

public class Tests {
    @Test
    public void testSum() throws Exception {
        double res = calculate("1","+","2");
        Assert.assertEquals(3, res, 0.0);
    }

    @Test
    public void testSubtraction() throws Exception {
        double res = calculate("1","-","2");
        Assert.assertEquals(-1, res, 0.0);
    }

    @Test
    public void testMultiplication() throws Exception {
        double res = calculate("1","*","2");
        Assert.assertEquals(2, res, 0.0);
    }

    @Test
    public void testDivision() throws Exception {
        double res = calculate("1","/","2");
        Assert.assertEquals(0.5, res, 0.0);
    }

    @Test
    public void testForNegativeNumbers_1() throws Exception {
        double res = calculate("-1","+","2");
        Assert.assertEquals(1, res, 0.0);
    }

    @Test
    public void testForNegativeNumbers_2() throws Exception {
        double res = calculate("1","+","-2");
        Assert.assertEquals(-1, res, 0.0);
    }

    @Test
    public void testForNegativeNumbers_3() throws Exception {
        double res = calculate("-1","+","-2");
        Assert.assertEquals(-3, res, 0.0);
    }

    @Test
    public void test_1() throws Exception {
        double res = calculate("1","+","0.0000000000000000000000000000000001");
        Assert.assertEquals(1.0000000000000000000000000000000001, res, 0.0);
    }

    @Test
    public void test_2() throws Exception {
        double res = calculate("1","+","1000000000");
        Assert.assertEquals(1000000001, res, 0.0);
    }

    @Test
    public void testForWhitespace_1() throws Exception {
        String res = calcString(" 1 "," * "," 2 ");
        Assert.assertEquals("2.0", res);
    }

    @Test
    public void testInvalidValue_1() {
        try {
            calcString("A","*","2");
        } catch (Exception exception) {
            String expectedError = "empty String";
            Assert.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testInvalidValue_2() {
        try {
            calculate("1","plus","2");
        } catch (Exception exception) {
            String expectedError = "Can't find sign";
            Assert.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testInvalidValue_3() throws Exception {
        String res = calcString("1м2щ3","+","5€©4");
        Assert.assertEquals("177.0", res);
    }

    @Test
    public void testInvalidValue_4() throws Exception {
        String res = calcString("1,2\r3","+","5\n4");
        Assert.assertEquals("177.0", res);
    }

    @Test
    public void testInvalidValue_5(){
        try {
            calcString("1","+","--2");
        } catch (Exception exception) {
            String expectedError = "For input string: \"--2\"";
            Assert.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testFormat_1() throws Exception {
        double res = calculate("3e3","+","100");
        Assert.assertEquals(3100, res, 0.0);
    }

    @Test
    public void testInvalidValue_6() {
        try {
            calculate("1","+","0,4");
        } catch (Exception exception) {
            String expectedError = "For input string: \"0,4\"";
            Assert.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testInvalidValue_7() {
        try {
            calcString("1","","0,4");
        } catch (Exception exception) {
            String expectedError = "Can't find sign";
            Assert.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testInvalidValue_8() throws Exception {
        String res = calcString("1","a+b","2");
        Assert.assertEquals("3.0", res);
    }

    @Test
    public void testInvalidValue_9() throws Exception {
        String res = calcString("1","+-*/+-","2");
        Assert.assertEquals("3.0", res);
    }

    @Test
    public void testDivisionByZero_1() throws Exception {
        String res = calcString("1","/","0");
        Assert.assertEquals("Infinity", res);
    }

    @Test
    public void testDivisionByZero_2() throws Exception {
        String res = calcString("-1","/","0");
        Assert.assertEquals("-Infinity", res);
    }

    @Test
    public void testDivisionByZero_3() throws Exception {
        String res = calcString("-1","/","-0");
        Assert.assertEquals("Infinity", res);
    }

    @Test
    public void testDivisionByZero_4() throws Exception {
        String res = calcString("1","/","-0");
        Assert.assertEquals("-Infinity", res);
    }

    @Test
    public void testDivisionByZero_5() throws Exception {
        String res = calcString("0","/","0");
        Assert.assertEquals("NaN", res);
    }

    @Test
    public void testLargeNumbers_1() throws Exception {
        String res = calcString("1e3080","+","10000000000000000000000000000000000000000");
        Assert.assertEquals("Infinity", res);
    }

    @Test
    public void testLargeNumbers_2() throws Exception {
        String res = calcString("1e3080","*","10000000000000000000000000000000000000000");
        Assert.assertEquals("Infinity", res);
    }

    @Test
    public void testLargeNumbers_3() throws Exception {
        String res = calcString("1e3080","/","1e3070");
        Assert.assertEquals("NaN", res);
    }

    @Test
    public void testTypeBoundaries_1() throws Exception {
        String res = calcString("1.7976931348623157E308","+","1");
        Assert.assertEquals("Infinity", res);
    }

    @Test
    public void testTypeBoundaries_2() throws Exception {
        double res = calculate("1","+","1.7976931348623157E308");
        Assert.assertEquals(1.7976931348623158E308, res, 0.0);
    }

    @Test
    public void testTypeBoundaries_3() throws Exception {
        String res = calcString("2.2250738585072014e-308","-","3");
        Assert.assertEquals("-3.0", res);
    }

    @Test
    public void testTypeBoundaries_4() throws Exception {
        String res = calcString("2.2250738585072014e-308","-","2.2e-308");
        Assert.assertEquals("2.225073858507199E-292", res);
    }

    @Test
    public void testTypeBoundaries_5() throws Exception {
        String res = calcString("4.9E-324","+","3");
        Assert.assertEquals("3.0", res);
    }

    @Test
    public void testTypeBoundaries_6() throws Exception {
        String res = calcString("4.9E-324","+","1.2E-324");
        Assert.assertEquals("5.9E-323", res);
    }

    @Test
    public void test_4() throws Exception {
        double res = calculate("1","+","0.3");
        Assert.assertEquals(1.3, res, 0.0);
    }
}