// [Lv.0] 종이 자르기

package CodingTest.CodingTestIntro;

import java.util.List;

public class SlicePaper {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(2, 2),
                new TestCase(2, 5),
                new TestCase(1, 1));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.M, t.N);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    int M;
    int N;

    TestCase(int M, int N) {
        this.M = M;
        this.N = N;
    }
}

class Solution {
    public int solution(int M, int N) {
        return M * N - 1;
    }
}