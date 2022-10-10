package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
* TODO
*  Дан csv-файл с разделителями «;», содержащий данные: Имя кота, вес кота, сердитость (true или false).
*  Сформировать текстовый файл каждая строка которого будет соответствовать строке входного файла и иметь вид:
*  <Сердитый (Дружелюбный)> кот <Имя> весом <n>кг.
*  Для этого описать интерфейс Transformable с методом void transform(String fileIn, String fileOut).
*  Параметрами задается имя входного и имя выходного файла.
*  Описать класс StreamTransformer, реализующий этот интерфейс при помощи классов FileInputStream / FileOuputStream
*/


public class App {
    public static void main( String[] args ) {

        StringBuilder result = new StringBuilder();
        FileInputStream stream;
        try {
            stream = new FileInputStream("cats.txt");
            int r;
            do {
                r = stream.read();
                result.append((char) r);
            } while (r != -1);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result);

        try {
            FileOutputStream outStream = new FileOutputStream("out.txt");
            outStream.write(result.toString().getBytes(StandardCharsets.UTF_8), 0, result.length());
            outStream.flush();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StreamTransformer streamTrans = new StreamTransformer();
        streamTrans.transform("cats.csv", "cats.txt");
    }

}
