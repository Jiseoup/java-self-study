// [Lv.0] 다항식 더하기

package CodingTest.CodingTestIntro;

import java.util.*;

public class SumPolynomial {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase("3x + 7 + x"),
                new TestCase("x + x + x"),
                new TestCase("x + 3 + 5"));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            String result = sol.solution(t.polynomial);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    String polynomial;

    TestCase(String polynomial) {
        this.polynomial = polynomial;
    }
}

class Solution {
    public String solution(String polynomial) {
        String[] valueArray = polynomial.split(" \\+ ");

        int linearValue = 0;
        int constantValue = 0;
        for (String value : valueArray) {
            // Calculate linear value.
            if (value.contains("x")) {
                String strXNum = value.replace("x", "");
                int xNum = !strXNum.equals("") ? Integer.parseInt(strXNum) : 1;
                linearValue += xNum;
            }
            // Calculate constant value.
            else {
                constantValue += Integer.parseInt(value);
            }
        }

        String answer = "";
        // Process linear value.
        if (linearValue > 0) {
            if (linearValue == 1)
                answer += "x";
            else
                answer += String.format("%dx", linearValue);
        }
        // Process constant value.
        if (constantValue > 0) {
            if (linearValue > 0)
                answer += String.format(" + %d", constantValue);
            else
                answer += Integer.toString(constantValue);
        }

        return answer;
    }
}