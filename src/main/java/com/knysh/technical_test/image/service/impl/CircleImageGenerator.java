package com.knysh.technical_test.image.service.impl;

import com.knysh.technical_test.image.Image;
import com.knysh.technical_test.image.service.CircleDrawer;
import com.knysh.technical_test.image.service.ImageGenerator;

import java.awt.Color;

public class CircleImageGenerator implements ImageGenerator, CircleDrawer {

    private Image image;

    @Override
    public Image start(String name, int width, int height) {
        image = new Image(name, width, height);
        return image;
    }

    @Override
    public void circle(int radius, int centerX, int centerY) {
        int x, y, p;
        x = 0;
        y = radius;
        fill(x, y, centerX, centerY);
        p = 1 - radius;
        while (x < y) {
            x = x + 1;
            if (p < 0) {
                p = p + 2 * x + 1;
            } else {
                y = y - 1;
                p = p + 2 * x + 1 - 2 * y;
            }
            fill(x, y, centerX, centerY);
        }
    }

    public void fill(int x, int y, int xc, int yc) {
        image.setPixel(xc + x, yc + y, Color.WHITE);
        image.setPixel(xc + x, yc - y, Color.WHITE);
        image.setPixel(xc - x, yc + y, Color.WHITE);
        image.setPixel(xc - x, yc - y, Color.WHITE);

        image.setPixel(xc + y, yc + x, Color.WHITE);
        image.setPixel(xc + y, yc - x, Color.WHITE);
        image.setPixel(xc - y, yc + x, Color.WHITE);
        image.setPixel(xc - y, yc - x, Color.WHITE);
    }

}
