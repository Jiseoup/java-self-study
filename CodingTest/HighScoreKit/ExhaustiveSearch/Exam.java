// [Lv.1] 모의고사

package CodingTest.HighScoreKit.ExhaustiveSearch;

import java.util.*;

public class Exam {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new int[] { 1, 2, 3, 4, 5 }),
                new TestCase(new int[] { 1, 3, 2, 4, 2 }),
                new TestCase(new int[] { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int[] result = sol.solution(t.answers);
            System.out.println(Arrays.toString(result));
        }
    }
}

// Create TestCase
class TestCase {
    int[] answers;

    TestCase(int[] answers) {
        this.answers = answers;
    }
}

class Solution {
    public int[] solution(int[] answers) {
        // Define student scores and patterns array.
        int[] scores = new int[3];
        int[][] patterns = {
                { 1, 2, 3, 4, 5 },
                { 2, 1, 2, 3, 2, 4, 2, 5 },
                { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
        };

        // Calculate student scores.
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                scores[j] += addScore(patterns[j], answers, i);
            }
        }

        // Get student max score.
        int maxScore = getMaxScore(scores);

        // Add high score students to the list.
        List<Integer> students = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                students.add(i + 1);
            }
        }

        // Convert list to array.
        int[] answer = new int[students.size()];
        for (int i = 0; i < students.size(); i++) {
            answer[i] = students.get(i);
        }

        return answer;
    }

    // Add score if answer matches the pattern.
    private int addScore(int[] pattern, int[] answers, int index) {
        return answers[index] == pattern[index % pattern.length] ? 1 : 0;
    }

    // Get max score from the array.
    private int getMaxScore(int[] scores) {
        int maxScore = 0;
        for (int score : scores) {
            if (score > maxScore)
                maxScore = score;
        }
        return maxScore;
    }
}
