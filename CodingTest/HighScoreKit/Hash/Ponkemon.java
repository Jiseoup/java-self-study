// [Lv.1] 폰켓몬

package CodingTest.HighScoreKit.Hash;

import java.util.*;

public class Ponkemon {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
            new TestCase(new int[] {3, 1, 2, 3}),
            new TestCase(new int[] {3, 3, 3, 2, 2, 4}),
            new TestCase(new int[] {3, 3, 3, 2, 2, 2})
        );

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.nums);
            System.out.println(result);
        }
    }
}


// Create TestCase
class TestCase {
    int[] nums;

    TestCase(int[] nums) {
        this.nums = nums;
    }
}


class Solution {
    public int solution(int[] nums) {
        int totalCount = nums.length;

        // HashMap(ponkemon number, count).
        Map<Integer, Integer> ponkemons = new HashMap<Integer, Integer>();
        
        // Initialize the Map structure.
        for (int i = 0; i < totalCount; i++) {
            ponkemons.put(nums[i], 0);
        }
        
        // // (Can Skip) Set ponkemon counts.
        // for (int i = 0; i < totalCount; i++) {
        //     int ponkemon = nums[i];
        //     ponkemons.replace(ponkemon, ponkemons.get(ponkemon) + 1);
        // }
        
        return Math.min((totalCount / 2), ponkemons.size());
    }
}
