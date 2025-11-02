// [Lv.0] 저주의 숫자 3

package CodingTest.CodingTestIntro;

import java.util.*;

public class CurseNumberThree {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(15),
                new TestCase(40));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.n);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    int n;

    TestCase(int n) {
        this.n = n;
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer++;
            if (answer % 3 == 0 || String.valueOf(answer).contains("3"))
                continue;
            n--;
        }
        return answer;
    }
}