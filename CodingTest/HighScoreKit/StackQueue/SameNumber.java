// [Lv.1] 같은 숫자는 싫어

package CodingTest.HighScoreKit.StackQueue;

import java.util.*;

public class SameNumber {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
            new TestCase(new int[] {1,1,3,3,0,1,1}),
            new TestCase(new int[] {4,4,4,3,3})
        );

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            LinkedList<Integer> result = sol.solution(t.arr);
            System.out.println(result);
        }
    }
}


// Create TestCase
class TestCase {
    int[] arr;

    TestCase(int[] arr) {
        this.arr = arr;
    }
}


class Solution {
    public LinkedList<Integer> solution(int[] arr) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                list.add(arr[i]);
                continue;
            }
            if (list.peekLast() != arr[i]) list.add(arr[i]);
        }
        return list;
    }
}
