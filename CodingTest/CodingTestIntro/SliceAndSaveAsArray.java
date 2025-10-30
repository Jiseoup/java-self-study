// [Lv.0] 잘라서 배열로 저장하기

package CodingTest.CodingTestIntro;

import java.util.*;

public class SliceAndSaveAsArray {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase("abc1Addfggg4556b", 6),
                new TestCase("abcdef123", 3));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            String[] result = sol.solution(t.my_str, t.n);
            System.out.println(Arrays.toString(result));
        }
    }
}

// Create TestCase
class TestCase {
    String my_str;
    int n;

    TestCase(String my_str, int n) {
        this.my_str = my_str;
        this.n = n;
    }
}

class Solution {
    public String[] solution(String my_str, int n) {
        StringBuilder sb = new StringBuilder(my_str);
        int size = (int) Math.ceil((float) sb.length() / n);

        String[] answer = new String[size];

        int idx = 0;
        while (sb.length() >= n) {
            answer[idx] = sb.substring(0, n);
            sb.delete(0, n);
            idx++;
        }

        if (sb.length() > 0) {
            answer[idx] = sb.toString();
        }

        return answer;
    }
}