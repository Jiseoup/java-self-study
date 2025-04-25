// [Lv.1] K번째수

package CodingTest.HighScoreKit.Sort;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class KNumber {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
            new TestCase(
                new int[] {1, 5, 2, 6, 3, 7, 4},
                new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}
            )
        );

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int[] result = sol.solution(t.array, t.commands);
            System.out.println(Arrays.toString(result));
        }
    }
}


// Create TestCase
class TestCase {
    int[] array;
    int[][] commands;

    TestCase(int[] array, int[][] commands) {
        this.array = array;
        this.commands = commands;
    }
}


class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int commandsLength = commands.length;
        int[] answer = new int[commandsLength];
        
        for (int x = 0; x < commandsLength; x++) {
            ArrayList<Integer> newArray = new ArrayList<Integer>();
            
            // Allocate commands to variable.
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            
            // Slicing array.
            for (int y = i - 1; y < j; y++) {
                newArray.add(array[y]);
            }
            Collections.sort(newArray);
            answer[x] = newArray.get(k - 1);
        }
        return answer;
    }
}
