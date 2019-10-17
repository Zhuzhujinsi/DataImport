package com.imooc.io;

import java.io.*;

public class IOUtil {
    /*
     *��ȡָ���ļ����ݣ�����16�������������̨
     * ����ÿ���10��byte����
     */
    public static void printHex(String fileName) throws IOException {
        //���ļ���Ϊ�ֽ������ж�����
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i = 1;
        while ((b = in.read()) != -1){
            if(b <= 0xf){
                //��λ��ǰ�油0
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + " ");
            if(i++ % 10 == 0)
                System.out.println();
        }
        in.close();
    }

    /**
     * �ļ��������ֽ�������ȡ��
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile(File srcFile, File destFile) throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("�ļ���" + srcFile + "������");
        }

        if(!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "�����ļ�");
        }

        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);

        byte[] buf = new byte[8 * 1024];
        int b;
        while ((b = in.read(buf, 0, buf.length)) != -1){
            out.write(buf, 0, b);
            out.flush();//��ü���
        }
        in.close();
        out.close();

    }

    /*
     *�����ļ��Ŀ��������ô�������ֽ���
     */
    public static void copyFileByBuffer(File srcFile, File destFile)throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("�ļ���" + srcFile + "������");
        }

        if(!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "�����ļ�");
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        int c;
        while ((c = bis.read()) != -1){
            bos.write(c);
            bos.flush();//ˢ�»�����
        }
        bis.close();
        bos.close();
    }
}
