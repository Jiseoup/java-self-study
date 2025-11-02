// [Lv.0] 7의 개수

package CodingTest.CodingTestIntro;

import java.util.*;

public class SumDigits {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(1234),
                new TestCase(930211));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.n);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    int n;

    TestCase(int n) {
        this.n = n;
    }
}

// Solution 1.
class Solution {
    public int solution(int n) {
        int answer = 0;

        String strNum = Integer.toString(n);
        StringBuilder sb = new StringBuilder(strNum);

        while (sb.length() > 0) {
            answer += Integer.parseInt(sb.substring(0, 1));
            sb.delete(0, 1);
        }
        return answer;
    }
}

// // Solution 2.
// class Solution {
//     public int solution(int n) {
//         int answer = 0;
        
//         String strNum = Integer.toString(n);
//         String[] array = strNum.split("");
        
//         for (int i = 0; i < array.length; i++) {
//             answer += Integer.parseInt(array[i]);
//         }
//         return answer;
//     }
// }