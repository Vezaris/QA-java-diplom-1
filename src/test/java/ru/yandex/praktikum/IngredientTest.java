package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

  private Ingredient ingredient;
  private final IngredientType ingredientType;
  private final String name;
  private final float price;
  private static final float DELTA = 0.1F;

  public IngredientTest(IngredientType ingredientType, String name, float price) {
    this.ingredientType = ingredientType;
    this.name = name;
    this.price = price;
  }

  @Before
  public void setUp() {
    ingredient = new Ingredient(ingredientType, name, price);
  }

  @Parameterized.Parameters(name = "{index}: {0} - {1} - {2}")
  public static Object[][] getDataEntry() {
    return new Object[][]{
        {IngredientType.SAUCE, "hot sauce", 100},
        {IngredientType.FILLING, "sausage", 300},
    };
  }

  @Test
  public void getPrice() {
    Assert.assertEquals("Получено неверное значение цены", price, ingredient.getPrice(), DELTA);
  }

  @Test
  public void getName() {
    Assert.assertEquals("Получено неверное название ингредиента", name, ingredient.getName());
  }

  @Test
  public void getType() {
    Assert.assertEquals("Получен неверный тип ингредиента", ingredientType, ingredient.getType());
  }
}