package com.imooc.io;

import java.io.*;

public class BrAndBwOrPwDemo {
    public static void main(String[] args) throws IOException {
        //���ļ����ж�д����
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\wangdeyu\\Documents\\Tencent Files\\964237881\\FileRecv\\02-00-00���� - ����.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\wangdeyu\\Documents\\Tencent Files\\964237881\\FileRecv\\02-00-00����.txt")));
        String line;
        while ((line = br.readLine()) != null){
//            System.out.println(line);//һ�ζ�һ�У�������ʶ����
            if(line.charAt(0) - '0' >= 0 && line.charAt(0) - '0' <= 9) {
                bw.write(line);
                //����д������
                bw.newLine();
            }
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
