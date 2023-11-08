package com.example.adapter.utils;

import com.mewebstudio.captcha.Captcha;
import com.mewebstudio.captcha.GeneratedCaptcha;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.awt.image.BufferedImage;

@Component
@SessionScope
public class CaptchaAdapter extends AbstractCaptchaGenerator {
    protected GeneratedCaptcha captcha;

    @Override
    public String newCaptcha() {
        captcha = new Captcha().generate();
        return captcha.getCode();
    }

    @Override
    public BufferedImage getImage() {
        return captcha.getImage();
    }
}
