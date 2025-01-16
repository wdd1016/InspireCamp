package util;

import java.util.function.IntPredicate;

// and(), or(), negate()

public class AndOrNegate {
    public static void main(String[] args) {
        IntPredicate predicate2x = n -> n % 2 == 0;
        IntPredicate predicate3x = n -> n % 3 == 0;

        IntPredicate predicate;
        boolean result;

        predicate = predicate2x.and(predicate3x);
        result = predicate.test(9);
        System.out.println("숫자 9는 2와 3의 배수입니까? " + result);

        predicate = predicate2x.or(predicate3x);
        result = predicate.test(9);
        System.out.println("숫자 9는 2 또는 3의 배수입니까? " + result);

        predicate = predicate2x.negate();
        result = predicate.test(9);
        System.out.println("숫자 9는 2의 배수가 아닙니까? " + result);
    }
}
