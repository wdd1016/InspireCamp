package generic;

class MyGenericClass<T> {
    private T t;

    public T get() {
        return this.t;
    }

    public void set(T t) {
        this.t = t;
    }
}

class KeyValue<K, V> {
    private K key;
    private V value;

    public K getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void print() {
        System.out.println(this.key + " = " + this.value);
    }
}

public class MyGeneric {
    public static void main(String[] args) {
        MyGenericClass<String> mc1 = new MyGenericClass<String>();
        mc1.set("안녕");
        System.out.println(mc1.get());
        MyGenericClass<Integer> mc2 = new MyGenericClass<>();
        mc2.set(1234);
        System.out.println(mc2.get());
        MyGenericClass<String> mc3 = new MyGenericClass<>();
        mc3.set("반가워요");
        // The method set(String) in the type MyClass<String> is not applicable for the arguments (int)
        // mc3.set(1234);
        System.out.println(mc3.get());
        System.out.println();

        KeyValue<String, Integer> kv1 = new KeyValue<>();
        kv1.setKey("사과");
        kv1.setValue(10000);
        kv1.print();
        KeyValue<Integer, String> kv2 = new KeyValue<>();
        kv2.setKey(1);
        kv2.setValue("첫번째");
        kv2.print();
        // 키 값만 사용하는 경우
        KeyValue<String, Void> kv3 = new KeyValue<>();
        kv3.setKey("키만사용");
        // kv3.setValue(10000); -> 불가능
        kv3.print();
    }

}
