import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            if (str.length() <= 8) {
                System.out.println("NG");
            }else {
                int ACount = 0;// 计算符号种类
                int aCount = 0;
                int count = 0;
                int others = 0;
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (c <= 'Z' && c >= 'A') {
                        ACount = 1;
                    }else if (c <= 'z' && c >= 'a') {
                        aCount = 1;
                    }else if (c <= '9' && c >= '0') {
                        count = 1;
                    }else {
                        others = 1;
                    }
                }
                if ((ACount + aCount + count + others) >= 3) {
                    //三个都不等于零，说明三个类型都存在
                    // 判断是否有相同长度超2的子串重复
                    boolean flg = false;
                    for (int i = 0; i < str.length() - 2; i++) {
                        String string = str.substring(i, i + 3);
                        if (str.substring(i + 2).contains(string)) {
                            flg = true;
                            System.out.println("NG");
                            break;
                        }
                    }
                    if (!flg) {
                        System.out.println("OK");
                    }
                }else {
                    System.out.println("NG");
                }
            }
        }
    }
}
