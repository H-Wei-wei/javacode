import java.io.*;

public class TestIO {
    public static void main(String[] args) {
        copyFile3();
    }

    private static void copyFile1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("g:/1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("g:/2.jpg");
        int len = -1;
        byte[] buffer = new byte[1024];
        while ((len = fileInputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    private static void copyFile2() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("g:/1.jpg");
            fileOutputStream = new FileOutputStream("g:/2.jpg");
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile3() {
        try (FileInputStream fileInputStream = new FileInputStream("g:/1.jpg");
             FileOutputStream fileOutputStream = new FileOutputStream("g:/2.jpg");){
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

