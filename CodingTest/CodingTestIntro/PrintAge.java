// [Lv.0] 나이 출력

package CodingTest.CodingTestIntro;

import java.util.*;

public class PrintAge {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(40),
                new TestCase(23));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.age);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    int age;

    TestCase(int age) {
        this.age = age;
    }
}

class Solution {
    public int solution(int age) {
        return 2022 - age + 1;
    }
}