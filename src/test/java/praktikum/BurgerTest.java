package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient firstIngredient;

    @Mock
    Ingredient secondIngredient;

    @Mock
    Ingredient thirdIngredient;

    @Test
    public void burgerSetBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Bun actualBun = burger.bun;
        Assert.assertEquals(bun, actualBun);
    }

    @Test
    public void burgerAddOneIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        int actualBurgerSize = burger.ingredients.size();
        int expectedBurgerSize = 1;
        Assert.assertEquals(expectedBurgerSize, actualBurgerSize);
        Assert.assertTrue(burger.ingredients.contains(firstIngredient));
    }

    @Test
    public void burgerAddTwoIngredientsTest() {
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        int actualBurgerSize = burger.ingredients.size();
        int expectedBurgerSize = 2;
        Assert.assertEquals(expectedBurgerSize, actualBurgerSize);
        Assert.assertTrue(burger.ingredients.contains(firstIngredient));
        Assert.assertTrue(burger.ingredients.contains(secondIngredient));
    }

}
