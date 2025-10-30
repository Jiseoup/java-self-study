// [Lv.0] 편지

package CodingTest.CodingTestIntro;

import java.util.*;

public class Letter {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase("happy birthday!"),
                new TestCase("I love you~"));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.message);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    String message;

    TestCase(String message) {
        this.message = message;
    }
}

class Solution {
    public int solution(String message) {
        return message.length() * 2;
    }
}