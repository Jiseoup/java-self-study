// [Lv.2] 의상

package CodingTest.HighScoreKit.Hash;

import java.util.*;

public class Clothes {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new String[][] { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
                        { "green_turban", "headgear" } }),
                new TestCase(new String[][] { { "crow_mask", "face" }, { "blue_sunglasses", "face" },
                        { "smoky_makeup", "face" } }),
                new TestCase(new String[][] { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
                        { "green_turban", "headgear" }, { "smoky_makeup", "face" } }),
                new TestCase(new String[][] { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
                        { "white_socks", "footwear" }, { "smoky_makeup", "face" } }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.clothes);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    String[][] clothes;

    TestCase(String[][] clothes) {
        this.clothes = clothes;
    }
}

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> hashMap = new HashMap<>();
        for (String[] cloth : clothes) {
            hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1], 0) + 1);
        }

        // Sum of products of all subsets: (N + 1)(M + 1)...
        int answer = 1;
        for (String key : hashMap.keySet()) {
            answer *= hashMap.get(key) + 1;
        }

        // Return `answer -1` to exclude empty set.
        return answer - 1;
    }
}