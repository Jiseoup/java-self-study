// [Lv.1] 붕대 감기

package CodingTest.PCCP;

import java.util.*;

public class Bandage {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new int[] { 5, 1, 5 }, 30, new int[][] { { 2, 10 }, { 9, 15 }, { 10, 5 }, { 11, 5 } }),
                new TestCase(new int[] { 3, 2, 7 }, 20, new int[][] { { 1, 15 }, { 5, 16 }, { 8, 6 } }),
                new TestCase(new int[] { 4, 2, 7 }, 20, new int[][] { { 1, 15 }, { 5, 16 }, { 8, 6 } }),
                new TestCase(new int[] { 1, 1, 1 }, 5, new int[][] { { 1, 2 }, { 3, 2 } }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.bandage, t.health, t.attacks);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    int[] bandage;
    int health;
    int[][] attacks;

    TestCase(int[] bandage, int health, int[][] attacks) {
        this.bandage = bandage;
        this.health = health;
        this.attacks = attacks;
    }
}

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // Define bandage time(t), recovery per seconds(x), and additional recovery(y).
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];

        // Define maxHealth, recoveryCount, and currentTime.
        int maxHealth = health;
        int recoveryCount = 0;
        int currentTime = 0;

        // Loop attacks.
        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int damage = attack[1];

            // Process recovery.
            while (attackTime != currentTime) {
                health = recovery(health, maxHealth, x);
                recoveryCount++;
                if (recoveryCount == t) {
                    health = recovery(health, maxHealth, y);
                    recoveryCount = 0;
                }
                currentTime++;
            }

            // Process damage;
            health -= damage;
            recoveryCount = 0;
            currentTime++;

            // If player is dead, return -1.
            if (health <= 0)
                return -1;
        }

        return health;
    }

    private int recovery(int health, int maxHealth, int value) {
        return Math.min(maxHealth, health + value);
    }
}