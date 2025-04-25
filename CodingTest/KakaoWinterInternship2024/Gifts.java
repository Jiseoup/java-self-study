// [Lv.1] 가장 많이 받은 선물

package CodingTest.KakaoWinterInternship2024;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Gifts {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
            new TestCase(
                new String[] {"muzi", "ryan", "frodo", "neo"},
                new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}
            ),
            new TestCase(
                new String[] {"joy", "brad", "alessandro", "conan", "david"},
                new String[] {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}
            ),
            new TestCase(
                new String[] {"a", "b", "c"},
                new String[] {"a b", "b a", "c a", "a c", "a c", "c a"}
            )
        );

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.friends, t.gifts);
            System.out.println(result);
        }
    }
}


// Create TestCase
class TestCase {
    String[] friends;
    String[] gifts;

    TestCase(String[] friends, String[] gifts) {
        this.friends = friends;
        this.gifts = gifts;
    }
}


class Solution {
    public int solution(String[] friends, String[] gifts) {
        int friendsCount = friends.length;
        
        // Map structure for store friends index.
        Map<String, Integer> friendsMap = new HashMap<String, Integer>();
        for (int i = 0; i < friendsCount; i++) {
            friendsMap.put(friends[i], i);
        }
        
        // Arrays for store gift count.
        int[][] giftCount = new int[friendsCount][friendsCount];
        
        // Arrays for store gift score.
        int[] giftScore = new int[friendsCount];
        
        // Analyzing the history of the exchange of gifts.
        for (String gift : gifts) {
            String[] giftList = gift.split(" ");
            int sender = friendsMap.get(giftList[0]);
            int receiver = friendsMap.get(giftList[1]);
            
            // Store gift sending count.
            giftCount[sender][receiver] += 1;
            
            // Calculate gift score.
            giftScore[sender] += 1;
            giftScore[receiver] -= 1;
        }

        int max = 0;
        for (int i = 0; i < giftCount.length; i++) {
            int count = 0;
            for (int j = 0; j < giftCount[i].length; j++) {
                // Compare gift counts.
                if (giftCount[i][j] > giftCount[j][i]) count++;
                // If gift counts are same.
                else if (giftCount[i][j] == giftCount[j][i]) {
                    // Compare gift score.
                    if (giftScore[i] > giftScore[j]) count++;
                }
            }
            if (max < count) max = count;
        }

        return max;
    }
}
