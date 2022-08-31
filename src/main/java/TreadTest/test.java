package TreadTest;

public class test {
    public static void main(String[] args) {
        Person a = new Person();
        a.setAge(15);
        a.setName("a");
        System.out.println(a.toString());
        Person b = a;
        b.setAge(45);
        System.out.println(a.toString());
        System.out.println(b.toString());

    }
}
