package com.example.adapter.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public interface CaptchaGeneratorInterface {
    byte[] generate() throws IOException;
    boolean confirmCode(String code);


}
