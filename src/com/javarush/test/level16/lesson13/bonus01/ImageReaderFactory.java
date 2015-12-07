package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Admin on 28.02.2015.
 */
public class ImageReaderFactory {
    public static synchronized ImageReader getReader(ImageTypes ip) {
        if (ip == ImageTypes.BMP)
            return new BmpReader();
        else if (ip == ImageTypes.JPG)
            return new JpgReader();
        else if (ip == ImageTypes.PNG)
            return new PngReader();
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");

    }
}
