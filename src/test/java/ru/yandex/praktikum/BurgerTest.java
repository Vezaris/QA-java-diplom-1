package ru.yandex.praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

  private Burger burger;
  private static final float DELTA = 0.1F;
  @Mock
  private Bun bunMock;
  @Mock
  private Ingredient ingredientMockTwo;
  @Mock
  private Ingredient ingredientMock;

  @Before
  public void setUp() {
    burger = new Burger();
  }

  @Test
  public void setBuns() {
    burger.setBuns(bunMock);
    assertEquals(bunMock, burger.bun);
  }

  @Test
  public void addIngredient() {
    burger.addIngredient(ingredientMock);
    assertTrue(burger.ingredients.contains(ingredientMock));
  }

  @Test
  public void removeIngredient() {
    burger.ingredients.add(0, ingredientMock);
    burger.removeIngredient(0);
    assertFalse(burger.ingredients.contains(ingredientMock));
  }

  @Test
  public void moveIngredient() {
    burger.ingredients.add(0, ingredientMock);
    burger.ingredients.add(1, ingredientMockTwo);
    burger.moveIngredient(0, 1);
    assertEquals(1, burger.ingredients.indexOf(ingredientMock));
  }

  @Test
  public void getPrice() {
    final float expectedPrice = 130F;
    burger.bun = bunMock;
    burger.ingredients.add(ingredientMock);
    Mockito.when(bunMock.getPrice()).thenReturn(50F);
    Mockito.when(ingredientMock.getPrice()).thenReturn(30F);
    assertEquals(expectedPrice, burger.getPrice(), DELTA);
  }

  @Test
  public void getReceipt() {
    burger.bun = bunMock;
    burger.ingredients.add(ingredientMock);
    Mockito.when(bunMock.getName()).thenReturn("Булка");
    Mockito.when(bunMock.getPrice()).thenReturn(50F);
    Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
    Mockito.when(ingredientMock.getName()).thenReturn("Соус");
    Mockito.when(ingredientMock.getPrice()).thenReturn(30F);
    String expected = String.format(
        "(==== Булка ====)%n" + "= sauce Соус =%n" + "(==== Булка ====)%n"
            + "%nPrice: 130,000000%n");
    assertEquals(expected, burger.getReceipt());
  }
}