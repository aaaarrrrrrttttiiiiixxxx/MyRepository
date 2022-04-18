import org.junit.Assert;
import org.junit.Test;
import static vadim.Main.calculate;

public class Tests {
    @Test
    public void testSum() {
        double res = calculate("1+2");
        Assert.assertEquals(3, res, 0.0);
    }

    @Test
    public void testSubtraction() {
        double res = calculate("1-2");
        Assert.assertEquals(-1, res, 0.0);
    }

    @Test
    public void testMultiplication() {
        double res = calculate("1*2");
        Assert.assertEquals(2, res, 0.0);
    }

    @Test
    public void testDivision() {
        double res = calculate("1/2");
        Assert.assertEquals(0.5, res, 0.0);
    }

    @Test
    public void testForNegativeNumbers_1() {
        double res = calculate("-1+2");
        Assert.assertEquals(1, res, 0.0);
    }

    @Test
    public void testForNegativeNumbers_2() {
        double res = calculate("1+-2");
        Assert.assertEquals(-1, res, 0.0);
    }

    @Test
    public void testForNegativeNumbers_3() {
        double res = calculate("-1+-2");
        Assert.assertEquals(-3, res, 0.0);
    }

    @Test
    public void testForWhitespace_1() {
        double res = calculate("1+- 2");
        Assert.assertEquals(-1, res, 0.0);
    }

    @Test
    public void testForWhitespace_2() {
        double res = calculate("1+ -2");
        Assert.assertEquals(-1, res, 0.0);
    }

    @Test
    public void testForWhitespace_3() {
        double res = calculate("1 +-2");
        Assert.assertEquals(-1, res, 0.0);
    }

    @Test
    public void testForWhitespace_4() {
        double res = calculate("        1+ -2");
        Assert.assertEquals(-1, res, 0.0);
    }

    @Test
    public void testInvalidValue_1() {
        try {
            double res = calculate("A+2");
        } catch (Exception exception) {
            String expectedError = "empty String";
            Assert.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testInvalidValue_2() {
        try {
            double res = calculate("1 plus 2");
        } catch (Exception exception) {
            String expectedError = "empty String";
            Assert.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void test_1() {
        double res = calculate("1s2d3 + 5k4");
        Assert.assertEquals(177, res, 0.0);
    }

    @Test
    public void test_2() {
        double res = calculate("1s2d3 + -5k4");
        Assert.assertEquals(69, res, 0.0);
    }
}