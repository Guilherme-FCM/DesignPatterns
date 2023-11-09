package com.example.adapter.utils;

import org.springframework.web.context.annotation.SessionScope;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@SessionScope
public abstract class AbstractCaptchaGenerator<T> implements CaptchaGeneratorInterface {
    private String code;

    @Override
    public final byte[] generate() throws IOException {
        T captcha = build();
        code = createCaptchaCode(captcha);

        BufferedImage image = getCaptchaImage(captcha);
        return bufferedImageToByteArray(image);
    }

    @Override
    public final boolean confirmCode(String code) {
        return this.code.equals(code);
    }

    public abstract T build();
    public abstract String createCaptchaCode(T captcha);
    public abstract BufferedImage getCaptchaImage(T captcha);

    private byte[] bufferedImageToByteArray(BufferedImage image) throws IOException {
        final var bytes = new ByteArrayOutputStream();
        ImageIO.write(image, "png", bytes);
        return bytes.toByteArray();
    }
}
