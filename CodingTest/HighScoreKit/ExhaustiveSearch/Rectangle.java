// [Lv.1] 최소 직사각형

package CodingTest.HighScoreKit.ExhaustiveSearch;

import java.util.*;

public class Rectangle {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new int[][] { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } }),
                new TestCase(new int[][] { { 10, 7 }, { 12, 3 }, { 8, 15 }, { 14, 7 }, { 5, 15 } }),
                new TestCase(new int[][] { { 14, 4 }, { 19, 6 }, { 6, 16 }, { 18, 7 }, { 7, 11 } }),
                new TestCase(new int[][] { { 50, 50 }, { 50, 50 }, { 50, 50 }, { 50, 50 }, { 50, 50 } }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.sizes);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    int[][] sizes;

    TestCase(int[][] sizes) {
        this.sizes = sizes;
    }
}

// Solution 1. (Review)
class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            maxWidth = Math.max(maxWidth, Math.max(size[0], size[1]));
            maxHeight = Math.max(maxHeight, Math.min(size[0], size[1]));
        }

        return maxWidth * maxHeight;
    }
}

// // Solution 2.
// class Solution {
//     public int solution(int[][] sizes) {
//         int maxWidth = 0;
//         int maxHeight = 0;

//         for (int[] size : sizes) {
//             int width = size[0];
//             int height = size[1];

//             if (width > height) {
//                 maxWidth = Math.max(maxWidth, width);
//                 maxHeight = Math.max(maxHeight, height);
//             } else {
//                 maxWidth = Math.max(maxWidth, height);
//                 maxHeight = Math.max(maxHeight, width);
//             }
//         }
//         return maxWidth * maxHeight;
//     }
// }
