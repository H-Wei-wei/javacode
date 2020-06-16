
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {
    public static void main(String[] args) throws IOException {
        File file = new File("g:/test");
//        System.out.println(file.exists());// 是否存在
//        System.out.println(file.isDirectory());// 是否是目录
//        file.delete();
//        System.out.println(file.exists());
//        file.createNewFile();
//        System.out.println(file.exists());
        //file.mkdirs();
        //System.out.println(file.exists());
//        System.out.println(file.isFile());
//        System.out.println(File.separator);
//        System.out.println(file.getCanonicalPath());
//        System.out.println(file.getParent());
//        System.out.println(file.getParentFile());
//        System.out.println(file.length());
//        System.out.println(new Date(file.lastModified()));
       // System.out.println(file.isDirectory());
        listAllFiles(file);
    }

    private static void listAllFiles(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                listAllFiles(file1);
             }
        }else {
            System.out.println(file);
        }
    }
}
