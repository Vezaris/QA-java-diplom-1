package ru.yandex.praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

  private Bun bun;
  private final String name;
  private final float price;
  private static final float DELTA = 0.1F;

  public BunTest(String name, float price) {
    this.name = name;
    this.price = price;
  }

  @Before
  public void setUp() {
    bun = new Bun(name, price);
  }

  @Parameterized.Parameters(name = "{index}: {0} - {1}")
  public static Object[][] getDataEntry() {
    return new Object[][]{
        {"black bun", 100},
        {"white bun", 200},
        {"red bun", 300},
    };
  }

  @Test
  public void getName() {
    assertEquals("Получено неверное имя", name, bun.getName());
  }

  @Test
  public void getPrice() {
    assertEquals("Получена неверная стоимость", price, bun.getPrice(), DELTA);
  }
}