package com.example.adapter.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class CaptchaGenerator implements CaptchaGeneratorInterface {
    protected String generatedCode;
    /**
     * Obtém um objeto {@link BufferedImage}, contendo uma imagem, para um array de bytes.
     * Isto permite a um endpoints retornar a imagem gerada em memória.
     * https://github.com/mewebstudio/java-captcha-generator
     * https://github.com/logicsquad/nanocaptcha

     * @param image imagem pra obter um array de bytes
     * @return array de bytes da imagem
     */
    protected byte[] bufferedImageToByteArray(BufferedImage image) throws IOException {
        final var baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }

    @Override
    public boolean confirmCode(String code) {
        return generatedCode.equals(code);
    }

    protected void setGeneratedCode(String generatedCode) {
        this.generatedCode = generatedCode;
    }
}
