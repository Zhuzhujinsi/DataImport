package com.imooc.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException{
        //�˽⹹�캯�������  �����
        File file = new File("E:\\Java IO\\imooc");
        //File file1 = new File("E:/Java IO/imooc");
        System.out.println(file.exists());
        file.renameTo(new File("E:\\Java IO\\imooc1"));
        if(!file.exists())
            file.mkdir();//file.mkdirs()�༶Ŀ¼����
        else
            file.delete();

        //�Ƿ���һ��Ŀ¼�������Ŀ¼����true���������Ŀ¼orĿ¼�����ڷ���false��
        System.out.println(file.isDirectory());
        //�Ƿ���һ���ļ�
        System.out.println(file.isFile());

        //File file2 = new File("e:\\Java IO\\�ռ�1.txt");
        File file2 = new File("e:\\Java IO", "�ռ�1.txt");
        if(!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            file2.delete();

        //���õ�File�����API
        System.out.println(file);//file.toString()������
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file2.getName());
        System.out.println(file.getParent());
        System.out.println(file2.getParent());
    }
}
