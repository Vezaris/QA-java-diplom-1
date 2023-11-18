package ru.yandex.praktikum;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {
    private Bun bun;
    final private String NAME = "булка";
    final private float PRICE = 60;

    @Before
    public void setUp() {
        bun = new Bun(NAME, PRICE);
    }

    @Test
    public void getName() {
        assertEquals("Получено неверное имя", NAME, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals("Получена неверная стоимость", PRICE, bun.getPrice(), 0.1);
    }
}