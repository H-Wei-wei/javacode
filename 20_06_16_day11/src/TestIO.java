import java.io.*;

public class TestIO {
    public static void main(String[] args) throws IOException {
        copyFile("g:/1.jpg", "g:/2.jpg");
    }

    private static void copyFile(String srcPath, String destPath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        int len = -1;
        byte[] buffer = new byte[1024];
        while ((len = fileInputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
