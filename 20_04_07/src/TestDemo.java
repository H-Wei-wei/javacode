


public class TestDemo {

    public static void main2(String[] args) {
        String s1="abc"+"def";//1
        String s2=new String(s1);//2
        if(s1.equals(s2))//3
            System.out.println(".equals succeeded");//4
        if(s1==s2)//5
            System.out.println("==succeeded");//6
    }

    String str = new String("good");
    char[ ] ch = { 'a' , 'b' , 'c' };
    public static void main(String[] args){
        TestDemo ex = new TestDemo();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }
    public void change(String str,char[ ] ch){
        str = "test ok";
        ch[0] = 'g';
    }
}

/*

public class TestDemo {
    public static boolean isAdmin(String userId){
        return userId.toLowerCase().equals("admin");
    }
    public static void main(String[] args){
        System.out.println(isAdmin("Admin"));
    }
}*/
