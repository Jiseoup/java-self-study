// Part 9. 정답을 XX로 나눈 나머지를 출력하세요

// 코딩 테스트: 정답이 변수(int, long 등)가 표현하는 범위를 넘어가는 경우가 있는 문제에 자주 출제.
// >> MOD 연산의 특성을 이용하여, 각 스텝마다 % 연산을 하며 문제를 풀어야 함.

/**
 * MOD 연산의 특성
 *  1. 덧셈/뺄셈/곱셈에 대하여 `분배 법칙`이 성립한다.
 *  2. 나눗셈에 대하여 `분배 법칙`이 성립하지 않는다.
 * 
 *  Example> (A + B) % C = ((A % C) + (B % C)) % C
 */

package Study;


public class Part9 {
    public static void main(String[] args) {
        try {
            ModExample.runAdd();
            ModExample.runSubstract();
            ModExample.runMultiply();
            ModExample.runDivide();
        }
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}


class ModExample {
    private static final int X = 126;
    private static final int Y = 98;
    private static final int SIZE = 10000;
    private static final int MODULO = 64;

    // 1. Add Example.
    public static void runAdd() throws Exception {
        System.out.println("[Add Example]");

        // Case 1: MOD applied after the entire loop.
        int calculate1 = 0;
        for (int i = 1; i < SIZE; i++) {
            calculate1 = (calculate1 + i) + (X + Y);
        }
        int result1 = calculate1 % MODULO;
        System.out.printf("Result 1: %d\n", result1);

        // Case 2: MOD applied during each iteration.
        int calculate2 = 0;
        for (int i = 1; i < SIZE; i++) {
            calculate2 = ((calculate2 % MODULO + i % MODULO) + (X % MODULO + Y % MODULO)) % MODULO;
        }
        int result2 = calculate2;
        System.out.printf("Result 2: %d\n", result2);

        // Returns true.
        System.out.printf("Equals: %s\n", result1 == result2);
        System.out.println();
    }

    // 2. Substract Example.
    public static void runSubstract() throws Exception {
        System.out.println("[Substract Example]");

        // Case 1: MOD applied after the entire loop.
        int calculate1 = 0;
        for (int i = 1; i < SIZE; i++) {
            calculate1 = (calculate1 + i) + (X - Y);
        }
        int result1 = calculate1 % MODULO;
        System.out.printf("Result 1: %d\n", result1);

        // Case 2: MOD applied during each iteration.
        int calculate2 = 0;
        for (int i = 1; i < SIZE; i++) {
            calculate2 = ((calculate2 % MODULO + i % MODULO) + (X % MODULO - Y % MODULO)) % MODULO;
        }
        int result2 = calculate2;
        System.out.printf("Result 2: %d\n", result2);

        // Returns true.
        System.out.printf("Equals: %s\n", result1 == result2);
        System.out.println();
    }

    // 3. Multiply Example.
    public static void runMultiply() throws Exception {
        System.out.println("[Multiply Example]");

        // Case 1: MOD applied after the entire loop.
        int calculate1 = 0;
        for (int i = 1; i < SIZE; i++) {
            calculate1 = (calculate1 + i) + (X * Y);
        }
        int result1 = calculate1 % MODULO;
        System.out.printf("Result 1: %d\n", result1);

        // Case 2: MOD applied during each iteration.
        int calculate2 = 0;
        for (int i = 1; i < SIZE; i++) {
            calculate2 = ((calculate2 % MODULO + i % MODULO) + (X % MODULO * Y % MODULO)) % MODULO;
        }
        int result2 = calculate2;
        System.out.printf("Result 2: %d\n", result2);

        // Returns true.
        System.out.printf("Equals: %s\n", result1 == result2);
        System.out.println();
    }

    // 4. Divide Example.
    public static void runDivide() throws Exception {
        System.out.println("[Divide Example]");

        // Case 1: MOD applied after the entire loop.
        int calculate1 = 0;
        for (int i = 1; i < SIZE; i++) {
            calculate1 = (calculate1 + i) + (X / Y);
        }
        int result1 = calculate1 % MODULO;
        System.out.printf("Result 1: %d\n", result1);

        // Case 2: MOD applied during each iteration.
        int calculate2 = 0;
        for (int i = 1; i < SIZE; i++) {
            calculate2 = ((calculate2 % MODULO + i % MODULO) + (X % MODULO / Y % MODULO)) % MODULO;
        }
        int result2 = calculate2;
        System.out.printf("Result 2: %d\n", result2);

        // Returns false.
        System.out.printf("Equals: %s\n", result1 == result2);
        System.out.println();
    }
}
