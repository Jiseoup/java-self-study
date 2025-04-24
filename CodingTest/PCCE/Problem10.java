package CodingTest.PCCE;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Problem10 {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
            new TestCase(
                new int[][] {
                    {1, 20300104, 100, 80},
                    {2, 20300804, 847, 37},
                    {3, 20300401, 10, 8}
                }, "date", 20300501, "remain"
            )
        );

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int[][] result = sol.solution(t.data, t.ext, t.val_ext, t.sort_by);
            System.out.println(Arrays.deepToString(result));
        }
    }
}


// Create TestCase
class TestCase {
    int[][] data;
    String ext;
    int val_ext;
    String sort_by;

    TestCase(int[][] data, String ext, int val_ext, String sort_by) {
        this.data = data;
        this.ext = ext;
        this.val_ext = val_ext;
        this.sort_by = sort_by;
    }
}


class Solution {
    private static String[] TARGET = {"code", "date", "maximum", "remain"};

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // Index to compare and sort with.
        int compareIndex = 0;
        int sortIndex = 0;

        // Get compare index and sort index.
        for (int i = 0; i < TARGET.length; i++) {
            if (TARGET[i].equals(ext)) compareIndex = i;
            if (TARGET[i].equals(sort_by)) sortIndex = i;
        }

        // Initialize the list.
        List<int[]> list = new ArrayList<int[]>();

        // Add list data based on condition.
        for(int i = 0; i < data.length; i++) {
            if(data[i][compareIndex] < val_ext) {
                list.add(data[i]);
            }
        }

        // Sort list data.
        final int finalSortIndex = sortIndex;
        list.sort(Comparator.comparingInt(listData -> listData[finalSortIndex]));

        // Convert list type to int[][] array.
        int[][] result = list.toArray(int[][]::new);

        return result;
    }
}
