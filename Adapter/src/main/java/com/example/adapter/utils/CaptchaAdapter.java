package com.example.adapter.utils;

import com.mewebstudio.captcha.Captcha;
import com.mewebstudio.captcha.GeneratedCaptcha;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.awt.image.BufferedImage;

public class CaptchaAdapter extends AbstractCaptchaGenerator<GeneratedCaptcha> {

    @Override
    public GeneratedCaptcha build() {
        return new Captcha().generate();
    }

    @Override
    public String createCaptchaCode(GeneratedCaptcha captcha) {
        return captcha.getCode();
    }

    @Override
    public BufferedImage getCaptchaImage(GeneratedCaptcha captcha) {
        return captcha.getImage();
    }
}
