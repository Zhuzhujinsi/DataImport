package com.imooc.io;

import java.io.*;

public class BrAndBwOrPwDemo {
    public static void main(String[] args) throws IOException {
        //对文件进行读写操作
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\wangdeyu\\Documents\\Tencent Files\\964237881\\FileRecv\\02-00-00副本 - 副本.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\wangdeyu\\Documents\\Tencent Files\\964237881\\FileRecv\\02-00-00副本.txt")));
        String line;
        while ((line = br.readLine()) != null){
//            System.out.println(line);//一次读一行，并不能识别换行
            if(line.charAt(0) - '0' >= 0 && line.charAt(0) - '0' <= 9) {
                bw.write(line);
                //单独写出换行
                bw.newLine();
            }
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
