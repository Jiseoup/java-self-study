// [Lv.0] 캐릭터의 좌표

package CodingTest.CodingTestIntro;

import java.util.*;

public class CharacterPosition {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new String[] { "left", "right", "up", "right", "right" }, new int[] { 11, 11 }),
                new TestCase(new String[] { "down", "down", "down", "down", "down" }, new int[] { 7, 9 }),
                new TestCase(new String[] { "down", "down", "down", "down", "up" }, new int[] { 7, 7 }));
        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int[] result = sol.solution(t.keyinput, t.board);
            System.out.println(Arrays.toString(result));
        }
    }
}

// Create TestCase
class TestCase {
    String[] keyinput;
    int[] board;

    TestCase(String[] keyinput, int[] board) {
        this.keyinput = keyinput;
        this.board = board;
    }
}

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        // Max/Min X ranges of the board.
        int minX = -board[0] / 2;
        int maxX = board[0] / 2;

        // Max/Min Y ranges of the board.
        int minY = -board[1] / 2;
        int maxY = board[1] / 2;

        // Character current position.
        int[] position = new int[2];

        // Move character.
        for (String input : keyinput) {
            switch (input) {
                case "right":
                    position[0] = position[0] < maxX ? position[0] + 1 : position[0];
                    break;
                case "left":
                    position[0] = position[0] > minX ? position[0] - 1 : position[0];
                    break;
                case "up":
                    position[1] = position[1] < maxY ? position[1] + 1 : position[1];
                    break;
                case "down":
                    position[1] = position[1] > minY ? position[1] - 1 : position[1];
                    break;
            }
        }
        return position;
    }
}