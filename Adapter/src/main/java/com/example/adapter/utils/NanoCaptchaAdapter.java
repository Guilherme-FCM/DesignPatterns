package com.example.adapter.utils;

import net.logicsquad.nanocaptcha.image.ImageCaptcha;
import org.springframework.web.context.annotation.SessionScope;

import java.awt.image.BufferedImage;

@SessionScope
public class NanoCaptchaAdapter extends AbstractCaptchaGenerator {
    protected ImageCaptcha captcha;

    @Override
    public String newCaptcha() {
        captcha = new ImageCaptcha.Builder(200, 50).addContent().build();
        return captcha.getContent();
    }

    @Override
    public BufferedImage getImage() {
        return captcha.getImage();
    }
}
