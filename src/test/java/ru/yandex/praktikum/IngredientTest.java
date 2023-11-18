package ru.yandex.praktikum;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class IngredientTest {
    private Ingredient ingredient;
    final private String NAME = "Ингредиент";
    final private float PRICE = 75;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, NAME, PRICE);
    }

    @Test
    public void getPrice() {
        Assert.assertEquals("Получено неверное значение цены", PRICE, ingredient.getPrice(), 0.01);
    }

    @Test
    public void getName() {
        Assert.assertEquals("Получено неверное название ингредиента", NAME, ingredient.getName());
    }

    @Test
    @Parameters ({
            "SAUCE",
            "FILLING"
    })
    public void getType(String ingredientType) {
        ingredient = new Ingredient(IngredientType.valueOf(ingredientType), NAME, PRICE);
        Assert.assertEquals("Получен неверный тип ингредиента", IngredientType.valueOf(ingredientType), ingredient.getType());
    }
}