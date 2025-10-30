// [Lv.0] 연속된 수의 합

package CodingTest.CodingTestIntro;

import java.util.*;

public class SumOfSequencialNumber {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(3, 12),
                new TestCase(5, 15),
                new TestCase(4, 14),
                new TestCase(5, 5));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int[] result = sol.solution(t.num, t.total);
            System.out.println(Arrays.toString(result));
        }
    }
}

// Create TestCase
class TestCase {
    int num;
    int total;

    TestCase(int num, int total) {
        this.num = num;
        this.total = total;
    }
}

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];

        int centerInt = total / num;
        int centerIntIndex = num % 2 == 0 ? num / 2 - 1 : num / 2;

        int plus = 1;
        int minus = 1;
        for (int i = 0; i < num; i++) {
            if (i > centerIntIndex) {
                answer[i] = centerInt + plus;
                plus += 1;
            } else if (i < centerIntIndex) {
                answer[i] = centerInt - minus;
                minus += 1;
            } else {
                answer[i] = centerInt;
            }
        }
        Arrays.sort(answer);

        return answer;
    }
}