package com.knysh.technical_test.image.service;

import com.knysh.technical_test.image.Image;

public interface ImageGenerator {

    Image start(String name, int width, int height);

}
