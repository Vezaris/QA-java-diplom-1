package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void valueSauce() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void valueFilling() {
        Assert.assertEquals( IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}