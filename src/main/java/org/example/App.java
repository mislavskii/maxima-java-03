package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
* TODO
*  ��� csv-���� � ������������� �;�, ���������� ������: ��� ����, ��� ����, ���������� (true ��� false).
*  ������������ ��������� ���� ������ ������ �������� ����� ��������������� ������ �������� ����� � ����� ���:
*  <�������� (�����������)> ��� <���> ����� <n>��.
*  ��� ����� ������� ��������� Transformable � ������� void transform(String fileIn, String fileOut).
*  ����������� �������� ��� �������� � ��� ��������� �����.
*  ������� ����� StreamTransformer, ����������� ���� ��������� ��� ������ ������� FileInputStream / FileOuputStream
*/


public class App {
    public static void main( String[] args ) throws Exception {

//        TextTransformer trans = new TextTransformer();
//        trans.transform("cats.csv", "cats.txt");

        StringBuilder result = new StringBuilder();
        FileInputStream stream;
        try {
            stream = new FileInputStream("cats.txt");
            int r;
            do {
                r = stream.read();
                result.append((char) r);
            } while (r != -1);
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
