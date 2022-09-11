package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Test data : {0} - {1}")
    public static Object[][] bunTestData() {
        return new Object[][]{
                {"С кунжутом", 45.5f},
                {"Чесночный", 30},
                {"", -24.0f}
        };
    }

    @Test
    public void bunGetNameTest() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        Assert.assertEquals(name, actualName);
    }

    @Test
    public void bunGetPriceTest() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(price, actualPrice, 0);
    }
}