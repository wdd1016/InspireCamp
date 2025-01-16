package util;

import java.util.function.Function;

// compose()
// 인터페이스AB = 인터페이스A.compose(인터페이스B);
// 최종결과 = 인터페이스AB.method();

// 인터페이스AB의 method()를 호출하면 우선 인터페이스B부터 처리하고 결과를 인터페이스A의 매개값으로 제공한다.
// 인터페이스A는 제공받은 매개값을 가지고 처리한 후 최종 결과를 리턴한다.

public class Compose {
    public static void main(String[] args) {
        Function<Member, Address> getAddressFromMember = m -> m.getAddress();
        Function<Address, String> getCityFromAddress = a -> a.getCity();

        Function<Member, String> getCityFromMember;
        String city;

        getCityFromMember = getAddressFromMember.andThen(getCityFromAddress);
        city = getCityFromMember.apply(new Member("홍길동", "HGD", new Address("한국", "서울")));
        System.out.println(city);
        System.out.println();

        getCityFromMember = getCityFromAddress.compose(getAddressFromMember);
        city = getCityFromMember.apply(new Member("홍길동", "HGD", new Address("한국", "서울")));
        System.out.println(city);
    }
}
