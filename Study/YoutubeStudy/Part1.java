// Part 1. int vs long

// 코딩 테스트: 대체로 `long`이 더 좋음.
// >> 문제의 답이나 풀이 과정에서 자료형의 범위를 넘어가는 경우가 종종 있기 때문.

package Study.YoutubeStudy;

import java.util.Scanner;
import java.util.InputMismatchException;


public class Part1 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            OverflowExample.run(scanner);
            RetryInvalidInputExample.run(scanner);
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input: Please enter a valid integer.");
            throw e;
        }
        catch (ArithmeticException e) {
            System.out.println("Overflow detected: " + e.getMessage());
            throw e;
        }
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
            throw e;
        }
    }
}


// 1. Overflow Example.
class OverflowExample {
    public static void run(Scanner scanner) {
        System.out.println("[Overflow Example]");

        try {
            // Input two integers.
            System.out.print("First Input (Integer): ");
            int x = scanner.nextInt();
            System.out.print("Second Input (Integer): ");
            int y = scanner.nextInt();

            // Sum two integers.
            int result = Math.addExact(x, y);
            System.out.printf("Result: %d + %d = %d\n", x, y, result);
            System.out.println(
                String.format(
                    "Result Type: %s",
                    ((Object) result).getClass().getName()
                )
            );
        }
        catch (InputMismatchException | ArithmeticException e) {
            throw e;
        }

        System.out.println();
    }
}


// 2. Retry Invalid Input Example.
class RetryInvalidInputExample {
    public static void run(Scanner scanner) {
        System.out.println("[Retry Invalid Input Example]");

        int x = 0;
        int y = 0;

        // Input two valid integers.
        while (true) {
            try {
                System.out.print("First Input (Integer): ");
                x = scanner.nextInt();
                System.out.print("Second Input (Integer): ");
                y = scanner.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input: Please enter a valid integer.\n");
                scanner.nextLine();
            }
        }

        // Sum two integers using `long` type.
        long result = (long)x + (long)y;
        System.out.printf("Result: %d + %d = %d\n", x, y, result);
        System.out.println(String.format(
                "Result Type: %s",
                ((Object) result).getClass().getName()
            )
        );

        System.out.println();
    }
}
