package com.imooc.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo1 {
    public static void main(String[] args) throws IOException {
        //����ļ������ڣ���ֱ�Ӵ�����������ڣ�ɾ���󴴽�
        FileOutputStream out = new FileOutputStream("demo/out.dat");
    }
}
