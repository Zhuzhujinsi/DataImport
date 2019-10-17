package com.imooc.io;

import java.io.*;

//列出File的一些常用操作比如过滤，遍历等操作
public class FileUtils {

    /*
     *列出指定目录下（包括其子目录）的所有文件
     */
    public static void listDirectory(File dir) throws Exception{

        if(!dir.exists())
            throw new IllegalArgumentException("目录：" + dir + "不存在!");

        if(!dir.isDirectory())
            throw new IllegalArgumentException(dir + "不是目录!");

//        String[] strings = dir.list();//（list()方法用于列出当前目录下的子目录和文件，但不能列出子目录的子目录）返回的是字符串数组
//        for (String string : strings){
//            System.out.println(dir + "\\" + strings);
//        }

        //如果要遍历子目录下的内容就需要构造成File对象做递归操作，File提供了直接返回File对象的方法
        File[] files = dir.listFiles();
        if(files != null && files.length > 0) {
            for (File file : files) {
                if(file.isDirectory()){
                    //递归调用
                    listDirectory(file);
                }else {
                    //System.out.println(file);
                    filtering(file);
                }
            }
        }
    }

    public static void filtering(File file) throws IOException{
        //对文件进行读写操作
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String line = br.readLine();
        if(line.charAt(0) - '0' >= 0 && line.charAt(0) - '0' <= 9){//如果.txt文件开头没有文件，即是可用的数据文件时，直接退出即可
            br.close();
            System.out.println("数据文件直接可用，无需处理！");
        }else {
            String fileName = file.getName();
            char[] temp = fileName.toCharArray();
            String newName = new String(temp, 0, temp.length - 4);
            File file1 = new File(file.getParent(), newName + "1" + ".txt");
            if(!file1.exists())
                file1.createNewFile();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1)));
            while ((line = br.readLine()) != null) {
                if (line.charAt(0) - '0' >= 0 && line.charAt(0) - '0' <= 9) {
                    bw.write(line);
                    bw.newLine();
                }
                //bw.flush();
            }
            IOUtil.copyFile(file1, file);
            br.close();
            bw.close();
            boolean success = file1.delete();
            System.out.println(success);
        }

    }

    public static void main(String[] args) throws Exception{
        listDirectory(new File("C:\\Users\\wangdeyu\\Desktop\\数据"));
    }
}
