// [Lv.0] 등수 매기기

package CodingTest.CodingTestIntro;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new int[][] { { 80, 70 }, { 90, 50 }, { 40, 70 }, { 50, 80 } }),
                new TestCase(new int[][] { { 80, 70 }, { 70, 80 }, { 30, 50 }, { 90, 100 }, { 100, 90 }, { 100, 100 },
                        { 10, 30 } }),
                new TestCase(new int[][] { { 80, 70 }, { 70, 80 } }),
                new TestCase(new int[][] { { 1, 3 }, { 3, 1 }, { 2, 3 }, { 3, 2 }, { 1, 2 }, { 1, 1 } }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int[] result = sol.solution(t.score);
            System.out.println(Arrays.toString(result));
        }
    }
}

// Create TestCase
class TestCase {
    int[][] score;

    TestCase(int[][] score) {
        this.score = score;
    }
}

class Solution {
    public int[] solution(int[][] score) {
        int length = score.length;

        // Initialize ranking array.
        int[] ranking = new int[length];
        for (int i = 0; i < length; i++) {
            ranking[i] = 1;
        }

        // Calculate ranking.
        for (int i = 0; i < length; i++) {
            double average1 = (double) (score[i][0] + score[i][1]) / 2;
            for (int j = 0; j < length; j++) {
                double average2 = (double) (score[j][0] + score[j][1]) / 2;
                if (average1 < average2) {
                    ranking[i] += 1;
                }
            }
        }

        return ranking;
    }
}