// [Lv.0] 문자열 밀기

package CodingTest.CodingTestIntro;

import java.util.*;

public class PushString {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase("hello", "ohell"),
                new TestCase("apple", "elppa"),
                new TestCase("atat", "tata"),
                new TestCase("abc", "abc"));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.A, t.B);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    String A;
    String B;

    TestCase(String A, String B) {
        this.A = A;
        this.B = B;
    }
}

class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        int length = A.length();

        for (int i = 0; i < length; i++) {
            if (A.equals(B))
                return answer;

            char last = A.charAt(length - 1);
            A = last + A.substring(0, length - 1);
            answer++;
        }

        return -1;
    }
}