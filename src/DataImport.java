import org.omg.CORBA.INTERNAL;

public class DataImport {
    public static void main(String[] args) throws Exception {
        String s = "慕课abc";
        byte[] bytes1 = s.getBytes();
//        int b = -170;
//        System.out.println(Integer.toHexString(b));
        for (byte b : bytes1){
            //把字节（转换成了int）以16进制的方式显示
            System.out.print(Integer.toHexString(b & 0xff) + " ");//把byte转换成int，就是一个字节转换成4个字节。
            //toHexString()返回整数参数（可以是有符号整数，也可以是无符号整数）的字符串（16进制表示的字符串）表示形式。
        }
        System.out.println();

        byte[] bytes2 = s.getBytes("gbk");
        for (byte b : bytes2){
            //GBK编码中文占用两个字节，英文占用一个字节
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        byte[] bytes3 = s.getBytes("utf-8");
        for (byte b : bytes3){
            //utf-8编码中文占用三个字节，英文占用1个字节
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        //java是双字节编码utf-16be
        byte[] bytes4 = s.getBytes("utf-16be");
        //utf-16be中文占用两个字节，英文也是两个字节
        for(byte b : bytes4){
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        /*
         *当你的字节序列是某种编码时，这个时候想把字节序列变成字符串，
         * 也需要用这种编码方式，否则会出现乱码
         */
        String str1 = new String(bytes4);//用项目默认的编码
        System.out.println(str1);

        String str2 = new String(bytes4, "utf-16be");
        System.out.println(str2);

    }
}
