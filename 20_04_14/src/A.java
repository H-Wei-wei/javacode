
public class A<T> {
    T value;

    A(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }

    public static void main(String[] args) {
        A<String> a = new A<>("hehe");
        System.out.println(a.get());
    }
}
