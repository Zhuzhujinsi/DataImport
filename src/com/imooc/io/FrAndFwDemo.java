package com.imooc.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("E:\\Java IO\\54373bf10001a1d400000000\\coreJava\\src\\file.txt");
        FileWriter fw = new FileWriter("E:\\Java IO\\54373bf10001a1d400000000\\coreJava\\src\\file2.txt");
        char[] buffer = new char[2056];
        int c;
        while ((c = fr.read(buffer, 0, buffer.length)) != -1){
            fw.write(buffer, 0, c);
            fw.flush();
        }
        fr.close();
        fw.close();
    }
}
