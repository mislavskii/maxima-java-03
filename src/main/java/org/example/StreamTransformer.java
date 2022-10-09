package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StreamTransformer implements Transformable{

    public void transform(String fileIn, String fileOut) {

        StringBuilder result = new StringBuilder();
        FileInputStream stream;
        FileOutputStream outStream;
        try {
            stream = new FileInputStream(fileIn);
            outStream = new FileOutputStream(fileOut);
            int r;
            do {
                r = stream.read();
                if (r == '\n' || (r == -1)) {
                    String[] arr = result.toString().split(";");
                    String angry = arr[2].equals("true") ? "Angry" : "Friendly";
                    String outLine = String.format("%s cat %s, weight %s kg.", angry, arr[0], arr[1]) + "\n";
                    outStream.write(outLine.getBytes(StandardCharsets.UTF_8), 0, outLine.length());
                    result = new StringBuilder();
                } else {
                    result.append((char) r);
                }
            } while (r != -1);

            outStream.flush();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
