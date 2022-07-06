package com.knysh.technical_test.image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Image {

    private final BufferedImage image;
    private final String name;

    public Image(String name, int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.name = name;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setPixel(int x, int y, Color color){
        try {
            image.setRGB(x, y, color.getRGB());
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Image)) return false;
        Image otherImage = (Image) other;
        return Objects.equals(image, otherImage.image) && Objects.equals(name, otherImage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, name);
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                '}';
    }
}
