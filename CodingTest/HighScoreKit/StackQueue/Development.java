// [Lv.2] 기능개발

package CodingTest.HighScoreKit.StackQueue;

import java.util.*;

public class Development {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 }),
                new TestCase(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int[] result = sol.solution(t.progresses, t.speeds);
            System.out.println(Arrays.toString(result));
        }
    }
}

// Create TestCase
class TestCase {
    int[] progresses;
    int[] speeds;

    TestCase(int[] progresses, int[] speeds) {
        this.progresses = progresses;
        this.speeds = speeds;
    }
}

// Solution 1: Using queue.
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        // Calculate days needed to complete each task and store in queue.
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.add(days);
        }

        List<Integer> answer = new ArrayList<>();

        while (!queue.isEmpty()) {
            int count = 1;
            int currentDay = queue.poll();

            // Count tasks that can be deployed on the same day or earlier.
            while (!queue.isEmpty() && queue.peek() <= currentDay) {
                queue.poll();
                count++;
            }
            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

// // Solution 2: Using index.
// class Solution {
//     public int[] solution(int[] progresses, int[] speeds) {
//         List<Integer> answer = new ArrayList<>();

//         int idx = 0;
//         int length = progresses.length;

//         while (idx < length) {
//             // Calculate days needed for current task.
//             int days = (int) Math.ceil((100.0 - progresses[idx]) / speeds[idx]);

//             // Count tasks that can be deployed on the same day.
//             int count = 0;
//             while (idx < length && progresses[idx] + speeds[idx] * days >= 100) {
//                 count++;
//                 idx++;
//             }
//             answer.add(count);
//         }
//
//         return answer.stream().mapToInt(i -> i.intValue()).toArray();
//     }
// }