package com.imooc.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo1 {
    public static void main(String[] args) throws IOException {
        //如果文件不存在，则直接创建，如果存在，删除后创建
        FileOutputStream out = new FileOutputStream("demo/out.dat");
    }
}
