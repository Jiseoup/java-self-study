// [Lv.0] 문자열 밀기

package CodingTest.CodingTestIntro;

import java.util.*;

public class ChickenCoupon {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(100),
                new TestCase(1081));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.chicken);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    int chicken;

    TestCase(int chicken) {
        this.chicken = chicken;
    }
}

// Solution 1.
class Solution {
    public int solution(int chicken) {
        int service = 0;
        int coupon = chicken;
        
        while (coupon >= 10) {
            service += coupon / 10;
            coupon = (coupon / 10) + (coupon % 10);
        }

        return service;
    }
}

// // Solution 2.
// class Solution {
//     public int solution(int chicken) {
//         int answer = 0;

//         while (true) {
//             if (chicken < 10)
//                 break;

//             int remain = chicken % 10;
//             answer += chicken /= 10;
//             chicken += remain;
//         }

//         return answer;
//     }
// }