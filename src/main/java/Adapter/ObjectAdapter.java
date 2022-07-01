package Adapter;

public class ObjectAdapter implements Targert{

    public Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }


    @Override
    public void request() {
        adaptee.test();
    }
}
