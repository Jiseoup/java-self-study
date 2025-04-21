package CodingTest.PCCE;

import java.util.Arrays;


public class Problem6 {
    public static void main(String[] args) {
        // Example 1
        int numbers1[] = {1};
        int our_score1[] = {100};
        int score_list1[] = {100, 80, 90, 84, 20};

        // Example 2
        int numbers2[] = {3, 4};
        int our_score2[] = {85, 93};
        int score_list2[] = {85, 92, 38, 93, 48, 85, 92, 56};

        // Solutions
        Solution sol = new Solution();
        String[] result1 = sol.solution(numbers1, our_score1, score_list1);
        System.out.println(Arrays.toString(result1));
        String[] result2 = sol.solution(numbers2, our_score2, score_list2);
        System.out.println(Arrays.toString(result2));
    }
}


class Solution {
    public String[] solution(int[] numbers, int[] our_score, int[] score_list) {
        int num_student = numbers.length;
        String[] answer = new String[num_student];

        for (int i = 0; i < num_student; i++) {
            if (our_score[i] == score_list[numbers[i] - 1]) {
                answer[i] = "Same";
            }
            else {
                answer[i] = "Different";
            }
        }

        return answer;
    }
}
