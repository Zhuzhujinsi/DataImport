package com.imooc.io;

import java.io.*;

public class IsrAndOswDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("E:\\Java IO\\54373bf10001a1d400000000\\coreJava\\src\\file.txt");
        InputStreamReader isr = new InputStreamReader(in);//默认项目的编码

        FileOutputStream out = new FileOutputStream("E:\\Java IO\\54373bf10001a1d400000000\\coreJava\\src\\file1.txt");
        OutputStreamWriter osw = new OutputStreamWriter(out);
//        int c;
//        while ((c = isr.read()) != -1){
//            System.out.print((char)c);
//        }
        char[] buffer = new char[8 * 1024];
        int c;
        //批量读取，放入buffer这个字符数组，从第0个数组开始放置，最多放buffer.length个，返回的是读到的字符个数
        while ((c = isr.read(buffer, 0, buffer.length)) != -1){
            String s = new String(buffer, 0, c);
            System.out.print(s);
            osw.write(buffer,0,c);
            osw.flush();
        }
        isr.close();
        osw.close();
    }
}
