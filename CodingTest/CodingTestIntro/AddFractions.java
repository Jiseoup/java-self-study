// [Lv.0] 분수의 덧셈

package CodingTest.CodingTestIntro;

import java.util.*;

public class AddFractions {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(1, 2, 3, 4),
                new TestCase(9, 2, 1, 3),
                new TestCase(1, 2, 1, 2),
                new TestCase(1, 4, 1, 4),
                new TestCase(3, 4, 3, 4));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int[] result = sol.solution(t.numer1, t.denom1, t.numer2, t.denom2);
            System.out.println(Arrays.toString(result));
        }
    }
}

// Create TestCase
class TestCase {
    int numer1;
    int denom1;
    int numer2;
    int denom2;

    TestCase(int numer1, int denom1, int numer2, int denom2) {
        this.numer1 = numer1;
        this.denom1 = denom1;
        this.numer2 = numer2;
        this.denom2 = denom2;
    }
}

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];

        int denom = lcm(denom1, denom2);
        int numer = (numer1 * (denom / denom1)) + (numer2 * (denom / denom2));

        int gcdValue = gcd(denom, numer);
        answer[0] = numer / gcdValue;
        answer[1] = denom / gcdValue;

        return answer;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}