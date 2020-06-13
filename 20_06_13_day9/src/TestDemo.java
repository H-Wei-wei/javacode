
public class TestDemo {
    public void add(Byte b) {
        b = b++;
    }
    public void Test() {
        Byte a = 127;
        byte b = 127;
        add(++a);
        System.out.println(a + " ");
        add(b);
        System.out.println(b + " ");
    }

    public static void main(String[] args) {
        TestDemo demo = new TestDemo();
        //demo.Test();
//        String str1 = "hello";
//        String str2 = "he" + new String("llo");
//        System.err.println(str1 == str2);
          try {

          } catch (java.io.IOError ex) {
              System.out.println("jIOError");
          }catch (java.lang.Exception ex) {
              System.out.println("Exception");
          }
    }
}
