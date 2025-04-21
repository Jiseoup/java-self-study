package CodingTest.PCCE;

import java.util.Scanner;
import java.util.Arrays;


public class Problem5 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Examples: NSSNEWWN [-1, 1], EESEEWNWSNWWNS [0, 0]
        System.out.print("Input: ");
        String input = scanner.nextLine();

        // Solutions
        Solution sol = new Solution();
        int[] result = sol.solution(input);
        System.out.println(Arrays.toString(result));
    }
}


class Solution {
    public int[] solution(String route) {
        int east = 0;
        int north = 0;
        int[] answer = new int [2];
        for(int i=0; i<route.length(); i++){
            switch(route.charAt(i)){
                case 'N':
                    north++;
                    break;
                case 'S':
                    north--;
                    break;
                case 'E':
                    east++;
                    break;
                case 'W':
                    east--;
                    break;
            }
        }
        answer[0] = east;
        answer[1] = north;
        return answer;
    }
}
