package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType actualType;
    private final String expectedType;

    public IngredientTypeTest(IngredientType actualType, String expectedType) {
        this.actualType = actualType;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters(name = "Test data : {0} - {1}")
    public static Object[][] ingredientTypeTestData() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"},
        };
    }

    @Test
    public void ingredientTypeTest() {
        Assert.assertEquals(expectedType, actualType.toString());
    }
}
