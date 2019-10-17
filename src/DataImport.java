import org.omg.CORBA.INTERNAL;

public class DataImport {
    public static void main(String[] args) throws Exception {
        String s = "Ľ��abc";
        byte[] bytes1 = s.getBytes();
//        int b = -170;
//        System.out.println(Integer.toHexString(b));
        for (byte b : bytes1){
            //���ֽڣ�ת������int����16���Ƶķ�ʽ��ʾ
            System.out.print(Integer.toHexString(b & 0xff) + " ");//��byteת����int������һ���ֽ�ת����4���ֽڡ�
            //toHexString()���������������������з���������Ҳ�������޷������������ַ�����16���Ʊ�ʾ���ַ�������ʾ��ʽ��
        }
        System.out.println();

        byte[] bytes2 = s.getBytes("gbk");
        for (byte b : bytes2){
            //GBK��������ռ�������ֽڣ�Ӣ��ռ��һ���ֽ�
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        byte[] bytes3 = s.getBytes("utf-8");
        for (byte b : bytes3){
            //utf-8��������ռ�������ֽڣ�Ӣ��ռ��1���ֽ�
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        //java��˫�ֽڱ���utf-16be
        byte[] bytes4 = s.getBytes("utf-16be");
        //utf-16be����ռ�������ֽڣ�Ӣ��Ҳ�������ֽ�
        for(byte b : bytes4){
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        /*
         *������ֽ�������ĳ�ֱ���ʱ�����ʱ������ֽ����б���ַ�����
         * Ҳ��Ҫ�����ֱ��뷽ʽ��������������
         */
        String str1 = new String(bytes4);//����ĿĬ�ϵı���
        System.out.println(str1);

        String str2 = new String(bytes4, "utf-16be");
        System.out.println(str2);

    }
}
