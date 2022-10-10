package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StreamTransformer implements Transformable{

    public void transform(String fileIn, String fileOut) {

        StringBuilder result = new StringBuilder();
        FileInputStream inStream;
        FileOutputStream outStream;
        try {
            inStream = new FileInputStream(fileIn);
            outStream = new FileOutputStream(fileOut);
            int r;
            do {
                r = inStream.read();
                if ( (r != -1) && (r != '\r') && (r != '\n') ) {
                    result.append((char) r);
                } else if (result.length() > 0) {
                    String[] arr = result.toString()
                            .replace('\r', ' ').replace('\n', ' ')
                            .trim().split(";");
                    String angry = arr[2].equals("true") ? "Angry" : "Friendly";
                    String name = arr[0];
                    String weight = arr[1];
                    String outLine = String.format("%s cat %s, weight %s kg.", angry, name, weight) + "\n";
                    outStream.write(outLine.getBytes(StandardCharsets.UTF_8), 0, outLine.length());
                    result = new StringBuilder();
                }
            } while (r != -1);
            outStream.flush();
            outStream.close();
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
