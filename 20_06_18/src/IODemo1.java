/**
 * 字节流
 */

import java.io.*;

public class IODemo1 {
    public static void main(String[] args){
        //copyFile();
        copyFile2();
    }

    private static void copyFile1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("g:/1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("g:/2.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer, 0, len);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    private static void copyFile2() {
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("g:/1.jpg"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("g:/2.jpg"));) {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
