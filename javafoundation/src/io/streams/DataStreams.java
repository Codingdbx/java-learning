package io.streams;

import java.io.*;

/**
 * 数据流-数据流支持基本数据类型值的二进制I/O（boolean，char，byte，short，int，long，float和double），以及字符串值。
 * 创建的是字节流
 * created by dbx on 2019/2/19
 */
public class DataStreams {
    static final String dataFile = "D:\\ideaprojects\\notes.test\\src\\invoicedata.txt";

    static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
    static final int[] units = { 12, 8, 13, 29, 50 };
    static final String[] descs = { "Java T-shirt",
            "Java Mug",
            "Duke Juggling Dolls",
            "Java Pin",
            "Java Key Chain" };

    public static void main(String[] args) throws IOException {


        DataOutputStream out = null;

        try {
            //DataStreams打开输出流，提供缓冲文件输出字节流，写到文件里
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));

            //DataStreams 写出记录并关闭输出流
            for (int i = 0; i < prices.length; i ++) {
                out.writeDouble(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
            }
        } finally {
            out.close();
        }

        DataInputStream in = null;
        double total = 0.0;
        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));

            double price;
            int unit;
            String desc;

            try {
                while (true) {//流读完会自动退出循环
                    price = in.readDouble();
                    unit = in.readInt();
                    desc = in.readUTF();
                    System.out.format("You ordered %d units of %s at $%.2f%n", unit, desc, price);
                    total += unit * price;
                }
            } catch (EOFException e) {

            }
            System.out.format("For a TOTAL of: $%.2f%n", total);

        } finally {
            in.close();
        }
    }
}
