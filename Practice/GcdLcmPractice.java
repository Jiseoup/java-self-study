package Practice;

import java.util.Arrays;

// 최대 공약수(GCD), 최소 공배수(LCM) 구하기 실습.
public class GcdLcmPractice {
    public static void main(String[] args) {
        // 두 개 숫자의 최대 공약수, 최소 공배수 구하기.
        int a = 48;
        int b = 60;
        System.out.printf("%d와 %d의 최대 공약수: %d\n", a, b, gcd(a, b));
        System.out.printf("%d와 %d의 최소 공배수: %d\n", a, b, lcm(a, b));
        System.out.println("-------------------------------------------");

        // N 개 숫자의 최대 공약수, 최소 공배수 구하기.
        int[] array = { 3, 6, 9, 12 };
        int gcdValue = array[0];
        int lcmValue = array[0];
        for (int i = 1; i < array.length; i++) {
            gcdValue = gcd(gcdValue, array[i]);
            lcmValue = lcm(lcmValue, array[i]);
        }
        String strArray = Arrays.toString(array);
        System.out.printf("%s의 최대 공약수: %d\n", strArray, gcdValue);
        System.out.printf("%s의 최소 공배수: %d", strArray, lcmValue);
    }

    // 최대 공약수 (Greatest Common Divisor)
    private static int gcd(int num1, int num2) {
        if (num2 == 0)
            return num1;
        return gcd(num2, num1 % num2);
    }

    // 최소 공배수 (Least Common Muliple)
    private static int lcm(int num1, int num2) {
        return num1 * num2 / gcd(num1, num2);
    }
}