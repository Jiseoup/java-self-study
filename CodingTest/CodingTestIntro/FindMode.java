// [Lv.0] 최빈값 구하기

package CodingTest.CodingTestIntro;

import java.util.*;

public class FindMode {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new int[] { 1, 2, 3, 3, 3, 4 }),
                new TestCase(new int[] { 1, 1, 2, 2 }),
                new TestCase(new int[] { 1 }),
                new TestCase(new int[] { 3, 4, 5, 1, 2, 3, 2, 2, 5 }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.array);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    int[] array;

    TestCase(int[] array) {
        this.array = array;
    }
}

class Solution {
    public int solution(int[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            hashMap.put(array[i], hashMap.getOrDefault(array[i], 0) + 1);
        }

        int maxKey = 0;
        int maxValue = 0;
        for (int key : hashMap.keySet()) {
            int hashValue = hashMap.get(key);
            if (hashValue > maxValue) {
                maxKey = key;
                maxValue = hashValue;
            } else if (hashValue == maxValue) {
                maxKey = -1;
            }
        }

        return maxKey;
    }
}