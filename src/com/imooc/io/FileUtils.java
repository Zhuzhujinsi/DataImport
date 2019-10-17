package com.imooc.io;

import java.io.*;

//�г�File��һЩ���ò���������ˣ������Ȳ���
public class FileUtils {

    /*
     *�г�ָ��Ŀ¼�£���������Ŀ¼���������ļ�
     */
    public static void listDirectory(File dir) throws Exception{

        if(!dir.exists())
            throw new IllegalArgumentException("Ŀ¼��" + dir + "������!");

        if(!dir.isDirectory())
            throw new IllegalArgumentException(dir + "����Ŀ¼!");

//        String[] strings = dir.list();//��list()���������г���ǰĿ¼�µ���Ŀ¼���ļ����������г���Ŀ¼����Ŀ¼�����ص����ַ�������
//        for (String string : strings){
//            System.out.println(dir + "\\" + strings);
//        }

        //���Ҫ������Ŀ¼�µ����ݾ���Ҫ�����File�������ݹ������File�ṩ��ֱ�ӷ���File����ķ���
        File[] files = dir.listFiles();
        if(files != null && files.length > 0) {
            for (File file : files) {
                if(file.isDirectory()){
                    //�ݹ����
                    listDirectory(file);
                }else {
                    //System.out.println(file);
                    filtering(file);
                }
            }
        }
    }

    public static void filtering(File file) throws IOException{
        //���ļ����ж�д����
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String line = br.readLine();
        if(line.charAt(0) - '0' >= 0 && line.charAt(0) - '0' <= 9){//���.txt�ļ���ͷû���ļ������ǿ��õ������ļ�ʱ��ֱ���˳�����
            br.close();
            System.out.println("�����ļ�ֱ�ӿ��ã����账��");
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
        listDirectory(new File("C:\\Users\\wangdeyu\\Desktop\\����"));
    }
}
