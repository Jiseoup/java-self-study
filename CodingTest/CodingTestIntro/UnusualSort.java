// [Lv.0] 특이한 정렬

package CodingTest.CodingTestIntro;

import java.util.*;

public class UnusualSort {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new int[] { 1, 2, 3, 4, 5, 6 }, 4),
                new TestCase(new int[] { 10000, 20, 36, 47, 40, 6, 10, 7000 }, 30));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int[] result = sol.solution(t.numlist, t.n);
            System.out.println(Arrays.toString(result));
        }
    }
}

// Create TestCase
class TestCase {
    int[] numlist;
    int n;

    TestCase(int[] numlist, int n) {
        this.numlist = numlist;
        this.n = n;
    }
}

class Solution {
    public int[] solution(int[] numlist, int n) {
        Arrays.sort(numlist);

        int size = numlist.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (numlist[i] == numlist[j])
                    continue;

                int abs1 = Math.abs(numlist[i] - n);
                int abs2 = Math.abs(numlist[j] - n);

                if (abs2 >= abs1) {
                    int temp = numlist[i];
                    numlist[i] = numlist[j];
                    numlist[j] = temp;
                }
            }
        }
        return numlist;
    }
}