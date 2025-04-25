// [Lv.1] 완주하지 못한 선수

package CodingTest.HighScoreKit.Hash;

import java.util.*;

public class Incomplete {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
            new TestCase(
                new String[] {"leo", "kiki", "eden"},
                new String[] {"eden", "kiki"}
            ),
            new TestCase(
                new String[] {"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[] {"josipa", "filipa", "marina", "nikola"}
            ),
            new TestCase(
                new String[] {"mislav", "stanko", "mislav", "ana"},
                new String[] {"stanko", "ana", "mislav"}
            )
        );

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            String result = sol.solution(t.participant, t.completion);
            System.out.println(result);
        }
    }
}


// Create TestCase
class TestCase {
    String[] participant;
    String[] completion;

    TestCase(String[] participant, String[] completion) {
        this.participant = participant;
        this.completion = completion;
    }
}


class Solution {
    public String solution(String[] participant, String[] completion) {     
        // Create hash map for store name and it's count.
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        
        // [CASE 1: Using `merge` method] Initialize and analyze hash map.
        for (String p : participant) hashMap.merge(p, 1, Integer::sum);
        for (String c : completion) hashMap.merge(c, -1, Integer::sum);

        // // [CASE 2: Using `getOrDefault` method] Initialize and analyze hash map.
        // for (String p : participant) hashMap.put(p, hashMap.getOrDefault(p, 0) + 1);
        // for (String c : completion) hashMap.replace(c, hashMap.get(c) - 1);
        
        // Find incompleted participant.
        for (String p : participant) if (hashMap.get(p) > 0) return p;
        return "";
    }
}
