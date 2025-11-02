// [Lv.0] 안전지대

package CodingTest.CodingTestIntro;

import java.util.*;

public class SafeArea {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 } }),
                new TestCase(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 0 },
                        { 0, 0, 0, 0, 0 } }),
                new TestCase(new int[][] { { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 } }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.board);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    int[][] board;

    TestCase(int[][] board) {
        this.board = board;
    }
}

class Solution {
    public int solution(int[][] board) {
        int n = board.length;

        // Create a newBoard.
        int[][] newBoard = new int[n][n];

        // Define position arrays to calculate bomb ranges.
        int[][] posArray = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { -1, 0 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

        // Calculate bomb ranges.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    bombRange(i, j, n, newBoard, posArray);
                }
            }
        }

        // Calculate safe areas.
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (newBoard[i][j] == 0)
                    answer++;
            }
        }

        return answer;
    }

    // Calculate bomb ranges function.
    private void bombRange(int x, int y, int length, int[][] newBoard, int[][] posArray) {
        newBoard[x][y] = 1;
        for (int[] pos : posArray) {
            int xPos = x + pos[0];
            int yPos = y + pos[1];

            if (xPos < 0 || yPos < 0 || xPos >= length || yPos >= length)
                continue;

            newBoard[x + pos[0]][y + pos[1]] = 1;
        }
    }
}