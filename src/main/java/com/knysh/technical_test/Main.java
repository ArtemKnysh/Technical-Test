package com.knysh.technical_test;

import com.knysh.technical_test.image.Image;
import com.knysh.technical_test.image.service.impl.CircleImageGenerator;
import com.knysh.technical_test.image.writer.ImageWriter;
import com.knysh.technical_test.image.writer.impl.FileImageWriter;

public class Main {

    public static void main(String[] args) {
        CircleImageGenerator circleImageGenerator = new CircleImageGenerator();
        Image exampleImage = circleImageGenerator.start("example.ipg", 100, 100);

        circleImageGenerator.circle(40, 50, 50);
        circleImageGenerator.circle(40, 20, 50);
        circleImageGenerator.circle(40, 50, 20);
        circleImageGenerator.circle(40, 80, 50);
        circleImageGenerator.circle(40, 50, 80);

        ImageWriter fileImageWriter = new FileImageWriter();
        fileImageWriter.write(exampleImage);
    }

}