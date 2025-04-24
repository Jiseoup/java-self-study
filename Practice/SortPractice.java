package Practice;

import java.util.Arrays;


public class SortPractice {
    public static void main(String[] args) {
        arraySort();
    }

    // 배열의 합이 큰 순서대로 출력.
    private static void arraySort() {
        System.out.println("[<Array Sort Practice]");

        // Define example array.
        int[][] array = {
            {1, 2, 3, 4},  // Sum: 10
            {8, 4, 6, 2},  // Sum: 20
            {0, 2, 1, 2},  // Sum: 5
            {5, 1, 7, 2}   // Sum: 15
        };

        // Print original array.
        System.out.println("<Original Array>");
        System.out.println(Arrays.deepToString(array));

        // Sort array in descending order.
        Arrays.sort(array, (a, b) -> sumList(b) - sumList(a));

        // Print sorted array.
        System.out.println("<Sorted Array>");
        System.out.println(Arrays.deepToString(array));
    }

    // Calculate total sum of the list.
    private static int sumList(int[] list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }
}
