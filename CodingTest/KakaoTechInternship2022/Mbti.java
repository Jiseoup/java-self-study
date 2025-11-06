// [Lv.1] 성격 유형 검사하기

package CodingTest.KakaoTechInternship2022;

import java.util.*;

public class Mbti {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(
                        new String[] { "AN", "CF", "MJ", "RT", "NA" },
                        new int[] { 5, 3, 2, 7, 5 }),
                new TestCase(
                        new String[] { "TR", "RT", "TR" },
                        new int[] { 7, 1, 3 }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            String result = sol.solution(t.survey, t.choices);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    String[] survey;
    int[] choices;

    TestCase(String[] survey, int[] choices) {
        this.survey = survey;
        this.choices = choices;
    }
}

class Solution {
    public String solution(String[] survey, int[] choices) {
        // Define indicators array.
        char[][] indicators = {
                { 'R', 'T' }, { 'C', 'F' }, { 'J', 'M' }, { 'A', 'N' }
        };

        // Define scoreMap to store the score of each indicator.
        Map<Character, Integer> scoreMap = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            char firstType = survey[i].charAt(0);
            char secondType = survey[i].charAt(1);

            // Add scores to the scoreMap.
            int score = Math.abs(choices[i] - 4);
            if (choices[i] <= 4)
                scoreMap.put(firstType, scoreMap.getOrDefault(firstType, 0) + score);
            else
                scoreMap.put(secondType, scoreMap.getOrDefault(secondType, 0) + score);
        }

        // Find a personality type.
        String answer = "";
        for (char[] indicator : indicators) {
            char first = indicator[0];
            char second = indicator[1];
            answer += scoreMap.getOrDefault(first, 0) >= scoreMap.getOrDefault(second, 0) ? first : second;
        }

        return answer;
    }
}
