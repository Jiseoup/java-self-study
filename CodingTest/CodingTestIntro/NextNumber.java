// [Lv.0] 다음에 올 숫자

package CodingTest.CodingTestIntro;

import java.util.*;

public class NextNumber {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new int[] { 1, 2, 3, 4 }),
                new TestCase(new int[] { 2, 4, 8 }),
                new TestCase(new int[] { -1, -2, -3 }),
                new TestCase(new int[] { -4, -3, -2, -1 }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.common);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    int[] common;

    TestCase(int[] common) {
        this.common = common;
    }
}

class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int diff = 0;
        int lastInt = common[common.length - 1];

        if (common[1] - common[0] == common[2] - common[1]) {
            diff = common[1] - common[0];
            answer = lastInt + diff;
        } else if (common[1] / common[0] == common[2] / common[1]) {
            diff = common[1] / common[0];
            answer = lastInt * diff;
        }
        return answer;
    }
}