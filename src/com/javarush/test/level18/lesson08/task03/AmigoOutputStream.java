package com.javarush.test.level18.lesson08.task03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream original;

    public AmigoOutputStream(FileOutputStream file) throws FileNotFoundException {
        super(fileName);
        this.original = file;
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        original.write(b, off, len);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        original.write(b);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public FileChannel getChannel()
    {
        return original.getChannel();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void finalize() throws IOException
    {
        super.finalize();    //To change body of overridden methods use File | Settings | File Templates.
    }


    @Override
    public void write(int b) throws IOException
    {
        original.write(b);
        //To change body of implemented methods use File | Settings | File Templates.
    }




    public void close() throws IOException {
        original.flush();
        original.write(new String("JavaRush © 2012-2013 All rights reserved.").getBytes());
        original.close();
    }

    public static void main(String[] args) throws IOException {
        AmigoOutputStream aos = new AmigoOutputStream(new FileOutputStream(fileName));
        aos.close();
    }

}

