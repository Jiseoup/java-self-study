package Practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// 입력한 기준보다 적은 수의 과일을 내림차순 정렬하여 출력.
public class StreamPractice {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the criteria (1~100) : ");
        int input = sc.nextInt();
        if ((input <= 0) || (input > 100)) {
            throw new IllegalArgumentException("Please enter a number between 1 and 100.");
        }

        // Create and Initialize fruit list.
        List<Fruit> fruitList = new ArrayList<>();
        Fruit.initialize(fruitList);

        // Print all fruits.
        System.out.println("[All Fruits]");
        for (Fruit fruit : fruitList) {
            System.out.printf("[%s:%d] ", fruit.name, fruit.quantity);
        }
        System.out.println();

        // Filter and sort(in descending order) fruits using stream method.
        List<Fruit> newfruitList = (fruitList.stream()
                .filter(f -> f.quantity < input)
                .sorted(Comparator.comparingInt((Fruit f) -> f.quantity).reversed())
                .toList());

        // Print filtered fruits.
        System.out.printf("[Fruits with a quantity less than %d]\n", input);
        for (Fruit fruit : newfruitList) {
            System.out.printf("[%s:%d] ", fruit.name.toUpperCase(), fruit.quantity);
        }
        System.out.println();
    }
}

class Fruit {
    String name;
    int quantity;

    public Fruit(String name) {
        this.name = name;
        this.quantity = new Random().nextInt(100) + 1;
    }

    public static void initialize(List<Fruit> list) {
        list.add(new Fruit("Apple"));
        list.add(new Fruit("Banana"));
        list.add(new Fruit("Grape"));
        list.add(new Fruit("Orange"));
        list.add(new Fruit("Melon"));
        list.add(new Fruit("Pear"));
        list.add(new Fruit("Lime"));
    }
}
