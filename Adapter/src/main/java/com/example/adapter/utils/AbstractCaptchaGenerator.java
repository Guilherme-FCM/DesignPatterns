package com.example.adapter.utils;

import lombok.Data;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Data
public abstract class AbstractCaptchaGenerator<T> implements CaptchaGeneratorInterface {
    protected String generatedCode;

    protected byte[] bufferedImageToByteArray(BufferedImage image) throws IOException {
        final var baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }

    @Override
    public final boolean confirmCode(String code) {
        return generatedCode.equals(code);
    }

    @Override
    public final byte[] generate() throws IOException {
        String code = newCaptcha();
        setGeneratedCode(code);

        BufferedImage image = getImage();
        return bufferedImageToByteArray(image);
    }

    public abstract String newCaptcha();
    public abstract BufferedImage getImage();
}
