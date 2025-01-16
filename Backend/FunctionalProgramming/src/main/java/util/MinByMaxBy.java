package util;

import java.util.function.BinaryOperator;

// BinaryOperator<T> 함수형 인터페이스에서 제공하는 정적 메서드로,
// 매개변수로 Comparator<T> 함수형 인터페이스를 제공

class Fruit {
    private String name;
    private int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}

public class MinByMaxBy {
    public static void main(String[] args) {
        BinaryOperator<Fruit> bio;
        Fruit fruit;

        System.out.println("MinBy");
        bio = BinaryOperator.minBy((f1, f2) -> Integer.compare(f1.getPrice(), f2.getPrice()));
        fruit = bio.apply(new Fruit("딸기", 12000), new Fruit("사과", 9000));
        System.out.println(fruit.getName());
        System.out.println();

        System.out.println("MaxBy");
        bio = BinaryOperator.maxBy((f1, f2) -> Integer.compare(f1.getPrice(), f2.getPrice()));
        fruit = bio.apply(new Fruit("딸기", 12000), new Fruit("사과", 9000));
        System.out.println(fruit.getName());
    }
}
