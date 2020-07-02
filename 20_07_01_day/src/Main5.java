import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // IP --》 十进制数
            String str = sc.next();
            getNum(str);
            // 十进制数 --》IP地址
            long n = Long.valueOf(sc.nextLine());
            getIP(n);
        }
    }
    private static void getNum(String str) {
        String[] split = str.split("\\.");
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < split.length; i++) {
            int n = Integer.valueOf(split[i]);
            StringBuffer sb1 = new StringBuffer("");
            for (int j = 0; j < 8; j++) {
                int m = n % 2; // 求模
                sb1.append(m);
                n = n / 2;
            }
            sb.append(sb1.reverse());
        }
        //System.out.println(sb);// 得到二进制 sb
        int sum = 0;
        for (int i = 0; i < sb.length(); i++) {
            int n = sb.charAt(i) - '0'; //由字符得到数字
            sum += n * Math.pow(2, sb.length() - 1 - i);
        }
        System.out.println(sum);
    }

    private static void getIP(long n) {
        StringBuffer sb = new StringBuffer("");
        while (n != 0) {
            long m = n % 2;
            sb.append(m);
            n = n / 2;
        }
        sb.reverse(); //倒写的二进制 --》正写的二进制
        int zeros = 32 - sb.length();
        if (sb.length() < 32) {
            for (int i = 0; i < zeros; i++) {
                sb = sb.insert(0, 0);// 补零
            }
        }

//        System.out.println(sb);
//        System.out.println(sb.substring(0,8));
//        System.out.println(sb.substring(8,16));
//        System.out.println(sb.substring(16,24));
//        System.out.println(sb.substring(24,32));

        String ret = "";
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            int num = sb.charAt(i) - '0';
            sum += num * Math.pow(2, 7 - i);
        }
        ret += sum + ".";
        sum = 0;
        for (int i = 8; i < 16; i++) {
            int num = sb.charAt(i) - '0';
            sum += num * Math.pow(2, 15 - i);
        }
        ret += sum + ".";
        sum = 0;
        for (int i = 16; i < 24; i++) {
            int num = sb.charAt(i) - '0';
            sum += num * Math.pow(2, 23 - i);
        }
        ret += sum + ".";
        sum = 0;
        for (int i = 24; i < 32; i++) {
            int num = sb.charAt(i) - '0';
            sum += num * Math.pow(2, 31 - i);
        }
        ret += sum;
        System.out.println(ret);
    }
}

/*
*
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String strIp = sc.nextLine();
            long numIp = Long.valueOf(sc.nextLine());
            System.out.println(ipToNum(strIp));
            System.out.println(numToIp(numIp));
        }
    }

    public static long ipToNum(String str){
        String[] strlist = str.split("\\.");
        StringBuilder sbAll = new StringBuilder();
        for(int i=0;i<strlist.length;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(Long.toBinaryString(Long.valueOf(strlist[i])));
            while(sb.length()<8){
                sb.insert(0, 0);
            }
            sbAll.append(sb);
        }
        return Long.valueOf(sbAll.toString(), 2);
    }

    public static String numToIp(long n){
        StringBuilder sb = new StringBuilder();
        StringBuilder numSb = new StringBuilder();
        sb.append(Long.toBinaryString(n));
        while(sb.length()<32){
            sb.insert(0, 0);
        }
        for(int i=0;i<4;i++){
            String temp = sb.substring(i*8, i*8+8);
            numSb.append(Long.valueOf(temp, 2));
            numSb.append(".");
        }
        numSb.deleteCharAt(numSb.length()-1);
        return numSb.toString();
    }
}
* */