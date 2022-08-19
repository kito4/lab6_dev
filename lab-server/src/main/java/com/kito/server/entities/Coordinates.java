package com.kito.server.entities;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * Класс описывающий объект координаты
 */
public class Coordinates {

    @Max(61)
    @NotNull
    private float X;
    private @NotNull Integer Y;

    /**
     * @return координата по X
     */
    public float getX() {
        return this.X;
    }

    /**
     * Метод, позволяющий задать координату по X
     * @param x значение координаты по X в строковом формате
     */
    public void setX(float x) {
        this.X = x;
    }

    /**
     * @return координата по Y
     */
    public @NotNull Integer getY() {
        return this.Y;
    }

    /**
     * Метод, позволяющий задать координату по Y
     * @param y значение координаты по X
     */
    public void setY(@NotNull Integer y) {
        this.Y = y;
    }
}
