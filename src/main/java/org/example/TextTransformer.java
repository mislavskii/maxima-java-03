package org.example;

import java.io.*;

public class TextTransformer implements Transformable{

    public void transform(String fileIn, String fileOut) throws IOException {
        FileWriter writer = new FileWriter(fileOut, false);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileIn));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] arr = line.split(";");
            String angry = arr[2].equals("true") ? "Сердитый" : "Дружелюбный";
            writer.write(String.format("%s кот %s весом %s кг.", angry, arr[0], arr[1]) + "\n");
        }
        writer.flush();
        writer.close();
        bufferedReader.close();
    }

}
