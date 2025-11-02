// [Lv.0] 유한소수 판별하기

package CodingTest.CodingTestIntro;

import java.util.*;

public class FiniteDecimal {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(7, 20),
                new TestCase(11, 22),
                new TestCase(12, 21),
                new TestCase(4, 15));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.a, t.b);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    int a;
    int b;

    TestCase(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Solution {
    public int solution(int a, int b) {
        int value = b / gcd(a, b);

        while (value % 2 == 0)
            value /= 2;
        while (value % 5 == 0)
            value /= 5;

        int answer = value == 1 ? 1 : 2;

        return answer;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}