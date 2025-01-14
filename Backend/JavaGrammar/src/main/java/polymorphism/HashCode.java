package polymorphism;

import java.util.HashMap;

// hashCode() ⇒ 객체의 위치값을 기준으로 생성한 고유값
// ⇒ Hashtable, HashMap 등의 객체에서 동등 비교를 할 때 해당 메서드를 오버라이딩해야 함
class HashCodeClass {
    String name;

    HashCodeClass(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HashCodeClass && this.name == ((HashCodeClass) obj).name) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

}

public class HashCode {
    public static void main(String[] args) {
        HashMap<Integer, String> hm1 = new HashMap<>();
        hm1.put(1, "데이터1");
        hm1.put(2, "데이터2");
        hm1.put(1, "데이터3");
        System.out.println(hm1);    // {1=데이터3, 2=데이터2}

        HashMap<HashCodeClass, String> hm2 = new HashMap<>();
        HashCodeClass a1 = new HashCodeClass("첫번째");
        HashCodeClass a2 = new HashCodeClass("두번째");
        HashCodeClass a3 = new HashCodeClass("첫번째");

        hm2.put(a1, "데이터1");
        hm2.put(a2, "데이터2");
        hm2.put(a3, "데이터3");
        System.out.println(hm2);    // {첫번째=데이터3, 두번째=데이터2}

        System.out.println(a1.hashCode());    // 51899483
        System.out.println(a2.hashCode());    // 45907648
        System.out.println(a3.hashCode());    // 51899483
    }
}
