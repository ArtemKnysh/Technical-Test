package com.knysh.technical_test.image.writer.impl;

import com.knysh.technical_test.image.Image;
import com.knysh.technical_test.image.writer.ImageWriter;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class FileImageWriter implements ImageWriter {

    @Override
    public void write(Image image) throws RuntimeException {
        try {
            ImageIO.write(image.getImage(), getImageFormat(image.getName()), new File(image.getName()));
        } catch (IOException e) {
            throw new RuntimeException("An IO error occurs while writing image to the file", e);
        }
    }

    public String getImageFormat(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1))
                .orElse("jpg");
    }

}
