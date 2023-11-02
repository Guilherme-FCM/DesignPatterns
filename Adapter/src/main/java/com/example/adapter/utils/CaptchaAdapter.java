package com.example.adapter.utils;

import com.mewebstudio.captcha.Captcha;
import com.mewebstudio.captcha.GeneratedCaptcha;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.awt.image.BufferedImage;
import java.io.IOException;

@SessionScope
public class CaptchaAdapter extends CaptchaGenerator {
    @Override
    public byte[] generate() throws IOException {
        GeneratedCaptcha captcha = new Captcha().generate();
        setGeneratedCode(captcha.getCode());

        BufferedImage captchaImage = captcha.getImage();
        return this.bufferedImageToByteArray(captchaImage);
    }
}
