package com.imooc.io;

import java.io.File;
import java.io.IOException;

public class IOUtilTest4 {
    public static void main(String[] args) {

        try {
            IOUtil.copyFile(new File("C:\\Users\\wangdeyu\\Documents\\Tencent Files\\964237881\\FileRecv\\02-00-00.txt"), new File("C:\\Users\\wangdeyu\\Documents\\Tencent Files\\964237881\\FileRecv\\02-00-00¸±±¾.txt"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
}
