package util;

import java.util.function.Predicate;

public class IsEqual {
    public static void main(String[] args) {
        Predicate<String> predicate;
        boolean result;

        predicate = Predicate.isEqual(null);
        result = predicate.test(null);
        System.out.println("null == null : " + result);

        predicate = Predicate.isEqual("Java");
        result = predicate.test(null);
        System.out.println("Java == null : " + result);

        predicate = Predicate.isEqual(null);
        result = predicate.test("Java");
        System.out.println("null == Java : " + result);

        predicate = Predicate.isEqual("Java");
        result = predicate.test("Java");
        System.out.println("Java == Java : " + result);
    }
}
