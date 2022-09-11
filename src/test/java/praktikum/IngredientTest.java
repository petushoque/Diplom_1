package praktikum;

import org.mockito.Mock;
import org.junit.Test;
import org.junit.Assert;
import static praktikum.IngredientType.*;

public class IngredientTest {

    @Mock
    Ingredient ingredient = new Ingredient(FILLING, "Капуста", 19.99f);

    @Test
    public void ingredientGetPriceTest() {
        float actualPrice = ingredient.getPrice();
        float expectedPrice = 19.99f;
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void ingredientGetNameTest() {
        String actualName = ingredient.getName();
        String expectedName = "Капуста";
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void ingredientGetTypeTest() {
        IngredientType actualType = ingredient.getType();
        IngredientType expectedType = FILLING;
        Assert.assertEquals(expectedType, actualType);
    }
}
