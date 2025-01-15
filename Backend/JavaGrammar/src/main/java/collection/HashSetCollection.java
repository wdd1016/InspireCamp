package collection;

import java.util.HashSet;
import java.util.Set;

class A {
    int data;

    public A(int data) {
        this.data = data;
    }
}

class B {
    int data;

    public B(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof B) {
            if (this.data == ((B) o).data)
                return true;
        }
        return false;
    }
}

class C {
    int data;

    public C(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof C) {
            if (this.data == ((C) o).data)
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() { // ⇐ this.data 가 동일하면 동일한 값을 반환하도록 구현
        // 3개 다 가능
        // return Objects.hash(this.data);
        // return (Integer.valueOf(this.data)).hashCode();
        return data;
    }
}

public class HashSetCollection {
    public static void main(String[] args) {
        Set<A> hashSet1 = new HashSet<>();
        hashSet1.add(new A(3));
        hashSet1.add(new A(3));
        hashSet1.add(new A(3));
        System.out.println(hashSet1.size());
        // collection.A@626b2d4a : 3, collection.A@515f550a : 3, collection.A@6504e3b2 : 3
        for (A a : hashSet1) {
            System.out.println(a + " : " + a.data);
        }
        System.out.println();

        Set<B> hashSet2 = new HashSet<>();
        hashSet2.add(new B(3));
        hashSet2.add(new B(3));
        hashSet2.add(new B(3));
        System.out.println(hashSet2.size());
        // collection.B@5ecddf8f : 3, collection.B@27abe2cd : 3, collection.B@3f102e87 : 3
        for (B b : hashSet2) {
            System.out.println(b + " : " + b.data);
        }
        System.out.println();

        Set<C> hashSet3 = new HashSet<>();
        hashSet3.add(new C(3));
        hashSet3.add(new C(3));
        hashSet3.add(new C(3));
        System.out.println(hashSet3.size());
        // collection.C@3 : 3
        for (C c : hashSet3) {
            System.out.println(c + " : " + c.data);
        }
        System.out.println();
    }
}
