// [Lv.0] 직사각형 넓이 구하기

package CodingTest.CodingTestIntro;

import java.util.*;

public class RectangleSize {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new int[][] { { 1, 1 }, { 2, 1 }, { 2, 2 }, { 1, 2 } }),
                new TestCase(new int[][] { { -1, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 } }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.dots);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    int[][] dots;

    TestCase(int[][] dots) {
        this.dots = dots;
    }
}

class Solution {
    public int solution(int[][] dots) {
        // Initialize max/min value.
        int minX = dots[0][0];
        int maxX = dots[0][0];
        int minY = dots[0][1];
        int maxY = dots[0][1];

        for (int[] dot : dots) {
            minX = Math.min(dot[0], minX);
            maxX = Math.max(dot[0], maxX);
            minY = Math.min(dot[1], minY);
            maxY = Math.max(dot[1], maxY);
        }

        return (maxX - minX) * (maxY - minY);
    }
}