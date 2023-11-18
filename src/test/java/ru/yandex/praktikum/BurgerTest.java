package ru.yandex.praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Spy;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Spy
    final private Bun BUN_SPY = new Bun("Булка", 50);
    @Spy
    final private Ingredient INGREDIENT_SPY = new Ingredient(IngredientType.SAUCE, "Соус", 30);
    @Spy
    final private Ingredient INGREDIENT_SPY_TWO = new Ingredient(IngredientType.FILLING, "Начинка", 100);

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(BUN_SPY);
        assertEquals(BUN_SPY, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(INGREDIENT_SPY);
        assertTrue(burger.ingredients.contains(INGREDIENT_SPY));
    }

    @Test
    public void removeIngredient() {
        burger.ingredients.add(0, INGREDIENT_SPY);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(INGREDIENT_SPY));
    }

    @Test
    public void moveIngredient() {
        burger.ingredients.add(0, INGREDIENT_SPY);
        burger.ingredients.add(1, INGREDIENT_SPY_TWO);
        burger.moveIngredient(0, 1);
        assertEquals(1, burger.ingredients.indexOf(INGREDIENT_SPY));
    }

    @Test
    public void getPrice() {
        final float EXPECTED_PRICE = 130;
        burger.bun = BUN_SPY;
        burger.ingredients.add(INGREDIENT_SPY);
        Mockito.when(BUN_SPY.getPrice()).thenReturn(50F);
        Mockito.when(INGREDIENT_SPY.getPrice()).thenReturn(30F);
        assertEquals(EXPECTED_PRICE, burger.getPrice(), 0.1);
    }

    @Test
    public void getReceipt() {
        burger.bun = BUN_SPY;
        burger.ingredients.add(INGREDIENT_SPY);
        Mockito.when(BUN_SPY.getName()).thenReturn("Булка");
        Mockito.when(BUN_SPY.getPrice()).thenReturn(50F);
        Mockito.when(INGREDIENT_SPY.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(INGREDIENT_SPY.getName()).thenReturn("Соус");
        Mockito.when(INGREDIENT_SPY.getPrice()).thenReturn(30F);
        String expected = String.format("(==== Булка ====)%n" + "= sauce Соус =%n" + "(==== Булка ====)%n" +"%nPrice: 130,000000%n");
        assertEquals(expected, burger.getReceipt());
    }
}