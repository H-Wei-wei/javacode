
import java.util.Scanner;
public class Main2 {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            double n=sc.nextDouble();
            System.out.println(change(n));
        }
    }
    public static String change(double n){
        StringBuffer result = new StringBuffer("");
        String str = String.valueOf(n);
        String[] arr = str.split("\\.");
        String[] arr1 = arr[0].split("");
        String[] arr2 = arr[1].split("");
        if(!(arr1.length == 1 && arr1[0].equals("0"))){
            for(int i = 0; i < arr1.length; i++){
                String s = getUnit(arr1[i],arr1.length - i);
                if(s.equals("零")){
                    if(i == arr1.length - 1){
                        result.append("元");
                    }else if(!arr1[i + 1].equals("0")){
                        result.append(s);
                    }
                }else{
                    result.append(s);
                }
            }
        }
        if(arr1.length == 2 || arr1.length == 6 || arr1.length == 10){
            result = new StringBuffer(result.substring(1));
        }
        String jiao = arr2[0];
        String fen = "0";
        if(arr2.length != 1){
            fen = arr2[1];
        }
        if(jiao.equals("0") && fen.equals("0")){
            //都为0为整
            result.append("整");
        }else{
            //其他则加小数
            jiao = getUnitArr2(jiao);
            fen = getUnitArr2(fen);
            if(!jiao.equals("0")){
                result.append(jiao + "角");
            }
            if(!fen.equals("0")){
                result.append(fen + "分");
            }

        }
        StringBuffer qz = new StringBuffer("人民币");
        result = qz.append(result);
        return result.toString();
    }

    private static String getUnitArr2(String s) {
        String s1 = s;
        switch (Integer.valueOf(s)){
            case 1: s1 = "壹";break;
            case 2: s1 = "贰";break;
            case 3: s1 = "叁";break;
            case 4: s1 = "肆";break;
            case 5: s1 = "伍";break;
            case 6: s1 = "陆";break;
            case 7: s1 = "柒";break;
            case 8: s1 = "捌";break;
            case 9: s1 = "玖";break;
        }
        return s1;
    }

    public static String getUnit(String s,int i){
        String s1 = "";
        String s2 = "";
        switch (i){
            case 1: s2 = "元";break;
            case 2: s2 = "拾";break;
            case 3: s2 = "佰";break;
            case 4: s2 = "仟";break;
            case 5: s2 = "万";break;
            case 6: s2 = "拾";break;
            case 7: s2 = "佰";break;
            case 8: s2 = "仟";break;
            case 9: s2 = "亿";break;
            case 10: s2 = "拾";break;
            case 11: s2 = "佰";break;
            case 12: s2 = "仟";break;

        }

        switch (Integer.valueOf(s)){
            case 1: s1 = "壹";break;
            case 2: s1 = "贰";break;
            case 3: s1 = "叁";break;
            case 4: s1 = "肆";break;
            case 5: s1 = "伍";break;
            case 6: s1 = "陆";break;
            case 7: s1 = "柒";break;
            case 8: s1 = "捌";break;
            case 9: s1 = "玖";break;
            case 0: return "零";
        }
        return s1 + s2;

    }
}