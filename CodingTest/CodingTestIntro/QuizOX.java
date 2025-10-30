// [Lv.0] OX퀴즈

package CodingTest.CodingTestIntro;

import java.util.*;

public class QuizOX {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new String[] { "3 - 4 = -3", "5 + 6 = 11" }),
                new TestCase(new String[] { "19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2" }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            String[] result = sol.solution(t.quiz);
            System.out.println(Arrays.toString(result));
        }
    }
}

// Create TestCase
class TestCase {
    String[] quiz;

    TestCase(String[] quiz) {
        this.quiz = quiz;
    }
}

class Solution {
    public String[] solution(String[] quiz) {
        int length = quiz.length;
        String[] answer = new String[length];

        for (int i = 0; i < length; i++) {
            String[] value = quiz[i].split(" ");

            String operator = value[1];
            int x = Integer.parseInt(value[0]);
            int y = Integer.parseInt(value[2]);
            int z = Integer.parseInt(value[4]);

            if (operator.equals("+"))
                answer[i] = x + y == z ? "O" : "X";
            else
                answer[i] = x - y == z ? "O" : "X";
        }

        return answer;
    }
}