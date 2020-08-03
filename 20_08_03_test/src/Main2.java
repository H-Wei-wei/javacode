
import java.util.Scanner;

public class Main2 {
    public static String maxDigitalStr(String str){
        char[] arrayChar = str.toCharArray();
        int maxLen = 0;
        String maxStr = "";
        int tempStrLen = 0;
        StringBuffer tempStr = new StringBuffer();
        for(int i = 0; i < arrayChar.length; i++){
            if(arrayChar[i] >= '0' && arrayChar[i] <= '9'){
                tempStr.append(arrayChar[i]);
                tempStrLen++;
                if(tempStrLen > maxLen){
                    maxLen = tempStrLen;
                    maxStr = tempStr.toString();
                }
            }else{
                tempStrLen = 0;
                tempStr.setLength(0);
            }
        }
        return maxStr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tempStr = sc.next();
        System.out.println(maxDigitalStr(tempStr));
    }

}