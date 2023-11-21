package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

  private final String ingredient;
  private final IngredientType expectedIngredient;

  public IngredientTypeTest(String ingredient, IngredientType expectedIngredient) {
    this.ingredient = ingredient;
    this.expectedIngredient = expectedIngredient;
  }

  @Parameterized.Parameters(name = "{index}: {0} - {1}")
  public static Object[][] getDataEntry() {
    return new Object[][]{
        {"SAUCE", IngredientType.SAUCE},
        {"FILLING", IngredientType.FILLING},
    };
  }

  @Test
  public void valueSauce() {
    assertEquals("Ингредиент отсутствует в перечислении",IngredientType.valueOf(ingredient), expectedIngredient);
  }
}