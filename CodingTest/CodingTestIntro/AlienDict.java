// [Lv.0] 외계어 사전

package CodingTest.CodingTestIntro;

import java.util.*;

public class AlienDict {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new String[] { "p", "o", "s" }, new String[] { "sod", "eocd", "qixm", "adio", "soo" }),
                new TestCase(new String[] { "z", "d", "x" }, new String[] { "def", "dww", "dzx", "loveaw" }),
                new TestCase(new String[] { "s", "o", "m", "d" },
                        new String[] { "moos", "dzx", "smm", "sunmmo", "som" }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.spell, t.dic);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    String[] spell;
    String[] dic;

    TestCase(String[] spell, String[] dic) {
        this.spell = spell;
        this.dic = dic;
    }
}

class Solution {
    public int solution(String[] spell, String[] dic) {
        int length = spell.length;
        for (String word : dic) {
            if (length != word.length())
                continue;

            int count = length;
            for (String str : spell) {
                if (word.contains(str))
                    count--;
            }

            if (count == 0)
                return 1;
        }
        return 2;
    }
}