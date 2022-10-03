package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;


/*
TODO:
Дан csv-файл с разделителями «;», содержащий данные:
Имя кота, вес кота, сердитость (true или false).
Сформировать текстовый файл каждая строка которого будет соответствовать строке входного файла и иметь вид:
<Сердитый (Дружелюбный)> кот <Имя> весом <n>кг.
Для этого описать интерфейс Transformable с методом void transform(String fileIn, String fileOut).
Параметрами задается имя входного и имя выходного файла.
Описать класса, реализующий этот интерфейс:
TextTransformer, при помощи классов FileReader / FileWriter
*/

public class App {
    public static void main( String[] args ) throws IncorrectCatWeightException, IOException {

        FileWriter writer = new FileWriter("cats.csv", false);

        Cat cat = CatFactory.createCat("Нетокот", -1);
        String text = cat.getName() + ";" + cat.getWeight() + ";" + cat.isAngry() + "\n";
        writer.write(text);

        System.out.println();

        cat = CatFactory.createCat("Хорокот", 4);
        text = cat.getName() + ";" + cat.getWeight() + ";" + cat.isAngry() + "\n";
        writer.write(text);

        writer.flush();
        writer.close();

        FileReader reader = new FileReader("pom.xml");
        int c;
        int counter = 0;
        while((c = reader.read()) != -1 && counter < 33) {
            counter++;
            System.out.print((char) c);
        }

        System.out.println();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("cats.csv"));
        String line;
        while((line = bufferedReader.readLine()) != null) {
            String[] arr = line.split(";");
            System.out.println(Arrays.toString(arr));
        }

        TextTransformer trans = new TextTransformer();
        trans.transform("cats.csv", "cats.txt");

    }

}
