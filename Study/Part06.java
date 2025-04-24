// Part 6. 정적(Static) 변수

// 정적 변수는 클래스 로딩 시, 메모리에 한 번만 할당함.
// 즉, 클래스의 모든 인스턴스가 해당 변수를 공유함.

package Study;


public class Part06 {
    public static void main(String[] args) {
        try {
            NonStaticExample.run();
            StaticExample.run();
        }
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}


// 1. Non Static Example.
class NonStaticExample {
    public static void run() throws Exception {
        System.out.println("[Non Static Example]");

        int myNumber = 10;
        System.out.println("myNumber : " + myNumber);
        plusOne(myNumber);
        System.out.println("myNumber : " + myNumber);
        System.out.println();
    }

    private static void plusOne(int number) {
        number += 1;
        System.out.println("The method `plusOne` called.");
    }
}


// 2. Static Example.
class StaticExample {
    static int myNumber;

    public static void run() throws Exception {
        System.out.println("[Static Example]");

        myNumber = 10;
        System.out.println("myNumber : " + myNumber);
        plusOne();
        System.out.println("myNumber : " + myNumber);
        System.out.println();
    }

    private static void plusOne() {
        myNumber += 1;
        System.out.println("The method `plusOne` called.");
    }
}
