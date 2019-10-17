package com.imooc.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException{
        //了解构造函数的情况  查帮助
        File file = new File("E:\\Java IO\\imooc");
        //File file1 = new File("E:/Java IO/imooc");
        System.out.println(file.exists());
        file.renameTo(new File("E:\\Java IO\\imooc1"));
        if(!file.exists())
            file.mkdir();//file.mkdirs()多级目录创建
        else
            file.delete();

        //是否是一个目录（如果是目录返回true，如果不是目录or目录不存在返回false）
        System.out.println(file.isDirectory());
        //是否是一个文件
        System.out.println(file.isFile());

        //File file2 = new File("e:\\Java IO\\日记1.txt");
        File file2 = new File("e:\\Java IO", "日记1.txt");
        if(!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            file2.delete();

        //常用的File对象的API
        System.out.println(file);//file.toString()的内容
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file2.getName());
        System.out.println(file.getParent());
        System.out.println(file2.getParent());
    }
}
