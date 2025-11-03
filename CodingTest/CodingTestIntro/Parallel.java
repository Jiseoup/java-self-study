// [Lv.0] 평행

package CodingTest.CodingTestIntro;

import java.util.*;

public class Parallel {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new int[][] { { 1, 4 }, { 9, 2 }, { 3, 8 }, { 11, 6 } }),
                new TestCase(new int[][] { { 3, 5 }, { 4, 1 }, { 2, 4 }, { 5, 10 } }));

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

// Solution 1.
class Solution {
    public int solution(int[][] dots) {
        // Define all available cases.
        int[][] cases = {
                { 0, 1, 2, 3 },
                { 0, 2, 1, 3 },
                { 0, 3, 1, 2 }
        };

        // Check all available cases.
        for (int[] c : cases) {
            if (isParallel(dots[c[0]], dots[c[1]], dots[c[2]], dots[c[3]]))
                return 1;
        }
        return 0;
    }

    // Check if two lines are parallel.
    private boolean isParallel(int[] dot1, int[] dot2, int[] dot3, int[] dot4) {
        return getGradient(dot1, dot2) == getGradient(dot3, dot4);
    }

    // Get a gradient of the line connecting the two dots.
    private double getGradient(int[] dot1, int[] dot2) {
        return (double) (dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
    }
}

// // Solution 2 (Hard Coding - My First Solution).
// class Solution {
//     public int solution(int[][] dots) {
//         int[] a = dots[0];
//         int[] b = dots[1];
//         int[] c = dots[2];
//         int[] d = dots[3];
        
//         // Check all available cases.
//         if (isParallel(a, b, c, d) || isParallel(a, c, b, d) || isParallel(a, d, b, c))
//             return 1;
//         return 0;
//     }

//     // Check if two lines are parallel.
//     private boolean isParallel(int[] dot1, int[] dot2, int[] dot3, int[] dot4) {
//         return getGradient(dot1, dot2) == getGradient(dot3, dot4);
//     }

//     // Get a gradient of the line connecting the two dots.
//     private double getGradient(int[] dot1, int[] dot2) {
//         return (double) (dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
//     }
// }
