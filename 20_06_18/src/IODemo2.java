import java.io.*;
import java.util.Arrays;

/**
 * 字符流
 */
public class IODemo2 {
    public static void main(String[] args){
        //copyFile1();
        copyFile5();
    }

    private static void copyFile1() throws IOException {
        FileReader fileReader = new FileReader("g:/test.txt");
        FileWriter fileWriter = new FileWriter("g:/test2.txt");
        char[] buffer = new char[1024];
        int len = 0;
        while ((len = fileReader.read(buffer)) != -1) {
            fileWriter.write(buffer, 0 ,len);
            System.out.println(len);
        }
        fileReader.close();
        fileWriter.close();
    }

    private static void copyFile2(){
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("g:/test.txt");
            fileWriter = new FileWriter("g:/test2.txt");
            char[] buffer = new char[1024];
            int len = 0;
            while ((len = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0 ,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (fileReader != null) {
                fileReader.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile3(){
        try (FileReader fileReader = new FileReader("g:/test.txt");
             FileWriter fileWriter = new FileWriter("g:/test2.txt")){
            char[] buffer = new char[1024];
            int len = 0;
            while ((len = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0 ,len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile4(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("g:/test.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("g:/test2.txt"))){
            char[] buffer = new char[1024];
            int len = 0;
            while ((len = bufferedReader.read(buffer)) != -1) {
                bufferedWriter.write(buffer, 0 ,len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copyFile5(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("g:/test.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("g:/test2.txt"))){
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line + "\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
