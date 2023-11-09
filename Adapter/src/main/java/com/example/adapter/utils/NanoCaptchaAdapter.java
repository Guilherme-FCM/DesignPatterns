package com.example.adapter.utils;

import net.logicsquad.nanocaptcha.image.ImageCaptcha;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.awt.image.BufferedImage;

@Component
public class NanoCaptchaAdapter extends AbstractCaptchaGenerator<ImageCaptcha> {
    @Override
    public ImageCaptcha build() {
        return new ImageCaptcha.Builder(200, 50).addContent().build();
    }

    @Override
    public String createCaptchaCode(ImageCaptcha captcha) {
        return captcha.getContent();
    }

    @Override
    public BufferedImage getCaptchaImage(ImageCaptcha captcha) {
        return captcha.getImage();
    }

}
