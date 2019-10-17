package com.imooc.io;

import java.io.IOException;

public class IOUtilTest1 {
    public static void main(String[] args) {
        try {
            IOUtil.printHex("E:\\jd\\src\\Main.java");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
