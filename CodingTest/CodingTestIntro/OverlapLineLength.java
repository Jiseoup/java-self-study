// [Lv.0] 겹치는 선분의 길이

package CodingTest.CodingTestIntro;

import java.util.*;

public class OverlapLineLength {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new int[][] { { 0, 1 }, { 2, 5 }, { 3, 9 } }),
                new TestCase(new int[][] { { -1, 1 }, { 1, 3 }, { 3, 9 } }),
                new TestCase(new int[][] { { 0, 5 }, { 3, 9 }, { 1, 10 } }),
                new TestCase(new int[][] { { 0, 2 }, { -3, -1 }, { -2, 1 } }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.lines);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    int[][] lines;

    TestCase(int[][] lines) {
        this.lines = lines;
    }
}

class Solution {
    public int solution(int[][] lines) {
        // Sort lines in ascending order by its X Value.
        Arrays.sort(lines, (a, b) -> a[0] - b[0]);

        // Define previous X, Y value.
        int previousX = lines[0][0];
        int previousY = lines[0][1];

        int answer = 0;
        for (int i = 1; i < lines.length; i++) {
            int x = Math.max(previousX, lines[i][0]);
            int y = Math.min(previousY, lines[i][1]);

            // If the lines are overlap.
            if (y > x) {
                answer += y - x;
                previousX = y;
                previousY = Math.max(previousY, lines[i][1]);
            }
            // If the lines do not overlap, initialize previous X, Y value.
            else {
                previousX = lines[i][0];
                previousY = lines[i][1];
            }
        }
        return answer;
    }
}