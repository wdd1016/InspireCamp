package util;

import java.util.function.Consumer;

// andThen()
// 인터페이스AB = 인터페이스A.andThen(인터페이스B);
// 최종결과 = 인터페이스AB.method();

// 인터페이스AB의 method()를 호출하면 우선 인터페이스A부터 처리하고 결과를 인터페이스B의 매개값으로 제공한다.
// 인터페이스B는 제공받은 매개값을 가지고 처리한 후 최종 결과를 리턴한다.

class Member {
    private String name;
    private String id;
    private Address address;

    public Member(String name, String id, Address address) {
        super();
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }
}

class Address {
    private String country;
    private String city;

    public Address(String country, String city) {
        super();
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}

public class AndThen {
    public static void main(String[] args) {
        Consumer<Member> memberNameConsumer = m -> System.out.println("memberNameConsumer: " + m.getName());
        Consumer<Member> memberIdConsumer = m -> System.out.println("memberIdConsumer: " + m.getId());

        Consumer<Member> memberNameIdConsumer = memberNameConsumer.andThen(memberIdConsumer);
        memberNameIdConsumer.accept(new Member("홍길동", "HGD", null));
        System.out.println();

        Consumer<Member> memberIdNameConsumer = memberIdConsumer.andThen(memberNameConsumer);
        memberIdNameConsumer.accept(new Member("홍길동", "HGD", null));
    }
}
