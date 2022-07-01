package Adapter;

// 适配器接口转换类
public class ClassAdapter extends Adaptee implements Targert{
    @Override
    public void request() {
        test();
    }
}
