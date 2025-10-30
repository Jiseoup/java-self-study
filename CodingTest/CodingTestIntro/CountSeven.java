// [Lv.0] 7의 개수

package CodingTest.CodingTestIntro;

import java.util.*;

public class CountSeven {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new int[] { 7, 77, 17 }),
                new TestCase(new int[] { 10, 29 }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.array);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    int[] array;

    TestCase(int[] array) {
        this.array = array;
    }
}

class Solution {
    public int solution(int[] array) {
        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            String value = Integer.toString(array[i]);

            int origLength = value.length();
            int newLength = value.replace("7", "").length();

            answer += origLength - newLength;
        }
        return answer;
    }
}