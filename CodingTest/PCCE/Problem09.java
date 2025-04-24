package CodingTest.PCCE;

import java.util.List;

public class Problem09 {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
            new TestCase(
                new String[][] {
                    {"blue", "red", "orange", "red"},
                    {"red", "red", "blue", "orange"},
                    {"blue", "orange", "red", "red"},
                    {"orange", "orange", "red", "blue"}
                }, 1, 1
            ),
            new TestCase(
                new String[][] {
                    {"yellow", "green", "blue"},
                    {"blue", "green", "yellow"},
                    {"yellow", "blue", "blue"}
                }, 0, 1
            )
        );

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.board, t.h, t.w);
            System.out.println(result);
        }
    }
}


// Create TestCase
class TestCase {
    String[][] board;
    int h;
    int w;

    TestCase(String[][] board, int h, int w) {
        this.board = board;
        this.h = h;
        this.w = w;
    }
}


class Solution {
    public int solution(String[][] board, int h, int w) {
        int count = 0;
        int n = board.length;

        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        for (int i = 0; i <= 3; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];

            if ((0 <= h_check) && (h_check < n) && (0 <= w_check) && (w_check < n)) {
                if (board[h][w].equals(board[h_check][w_check])) {
                    count++;
                }
            }
        }

        return count;
    }
}
