package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class TextTransformer implements Transformable{

    public void transform(String fileIn, String fileOut) throws IOException {
        FileWriter writer = new FileWriter(fileOut, false);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileIn));
        String line;
        while((line = bufferedReader.readLine()) != null) {
            String[] arr = line.split(";");
            String angry;
            if (Objects.equals(arr[2], "true")) {
                angry = "Сердитый";
            } else {
                angry = "Дружелюбный";
            }
            String outLine = angry + " кот " + arr[0] + " весом " + arr[1] + "кг.";
            writer.write(outLine + "\n");
        }
        writer.flush();
        writer.close();
        bufferedReader.close();

    }

}
