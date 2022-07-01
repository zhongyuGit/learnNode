package Adapter;

public class ObjectAdapterTest {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Targert targert = new ObjectAdapter(adaptee);
        targert.request();
    }
}
