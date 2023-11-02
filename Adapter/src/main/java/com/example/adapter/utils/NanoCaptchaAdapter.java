package com.example.adapter.utils;

import net.logicsquad.nanocaptcha.image.ImageCaptcha;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.awt.image.BufferedImage;
import java.io.IOException;

@Component
@SessionScope
public class NanoCaptchaAdapter extends CaptchaGenerator {
    @Override
    public byte[] generate() throws IOException {
        ImageCaptcha captcha = new ImageCaptcha.Builder(200, 50).addContent().build();
        setGeneratedCode(captcha.getContent());

        BufferedImage captchaImage = captcha.getImage();
        return this.bufferedImageToByteArray(captchaImage);
    }
}
