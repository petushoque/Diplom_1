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

    @Test
    public void burgerRemoveOneIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.removeIngredient(1);
        int actualBurgerSize = burger.ingredients.size();
        int expectedBurgerSize = 1;
        Assert.assertFalse(burger.ingredients.contains(secondIngredient));
        Assert.assertEquals(expectedBurgerSize, actualBurgerSize);
    }

    @Test
    public void burgerRemoveTwoIngredientsTest() {
        Burger burger = new Burger();
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.removeIngredient(0);
        burger.removeIngredient(0);
        int actualBurgerSize = burger.ingredients.size();
        int expectedBurgerSize = 0;
        Assert.assertFalse(burger.ingredients.contains(firstIngredient));
        Assert.assertFalse(burger.ingredients.contains(secondIngredient));
        Assert.assertEquals(expectedBurgerSize, actualBurgerSize);
    }

    @Test
    public void burgerMoveIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.ingredients.add(thirdIngredient);
        burger.moveIngredient(0, 2);
        Assert.assertEquals(firstIngredient, burger.ingredients.get(2));
    }

    @Test
    public void burgerGetPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        Mockito.when(bun.getPrice()).thenReturn(49.99f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(99.99f);
        float actualBurgerPrice = burger.getPrice();
        float expectedBurgerPrice = 199.97f;
        Assert.assertEquals(expectedBurgerPrice, actualBurgerPrice, 0);
    }

    @Test
    public void BurgerGetReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.ingredients.add(thirdIngredient);
        Mockito.when(bun.getName()).thenReturn("Чесночная булочка");
        Mockito.when(bun.getPrice()).thenReturn(79f);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(firstIngredient.getName()).thenReturn("Салями");
        Mockito.when(firstIngredient.getPrice()).thenReturn(119f);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("Сыр");
        Mockito.when(secondIngredient.getPrice()).thenReturn(109f);
        Mockito.when(thirdIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(thirdIngredient.getName()).thenReturn("Кетчунез");
        Mockito.when(thirdIngredient.getPrice()).thenReturn(9f);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt =
                        "(==== Чесночная булочка ====)\r\n" +
                        "= filling Салями =\r\n" +
                        "= filling Сыр =\r\n" +
                        "= sauce Кетчунез =\r\n" +
                        "(==== Чесночная булочка ====)\r\n" +
                        "\r\n" +
                        "Price: 395.000000\r\n";
        Assert.assertEquals(expectedReceipt, actualReceipt);
    }
}
