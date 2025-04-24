// Part 4. 오름차순(ASC) 정렬 vs 내림차순(DESC) 정렬

// sort : 정렬 기준이 한 개일 때 사용.

package Study.YoutubeStudy;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Part04 {
    public static void main(String[] args) {
        try {
            SortingExample.runAscSort();
            SortingExample.runDescSort();
        }
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}


class SortingExample {
    // 1. Ascending Order Example.
    public static void runAscSort() throws Exception {
        System.out.println("[Ascending Order Example]");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input five integers separated by a comma(,): ");

        // Input data into the array.
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");
        int[] myArray = new int[5];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = Integer.parseInt(st.nextToken().trim());
        }

        // Sort the array in ascending order.
        Arrays.sort(myArray);

        System.out.println(Arrays.toString(myArray));
        System.out.println();
    }

    // 2. Descending Order Example.
    public static void runDescSort() throws Exception {
        System.out.println("[Descending Order Example]");

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Select Descending Order Method (1, 2, 3): ");
            int inputMethod = scanner.nextInt();

            // Method 1: Using Integer Wrapper Class Array.
            if (inputMethod == 1) {
                System.out.printf("Method [%d] selected.\n", inputMethod);

                Integer myArray[] = {5, 2, 1, 9, 7};

                // Sort the array in descending order.
                Arrays.sort(myArray, Collections.reverseOrder());

                System.out.println(Arrays.toString(myArray));
                break;
            }
            // Method 2: int Array: Boxing int to Integer Wrapper Class.
            else if (inputMethod == 2) {
                System.out.printf("Method [%d] selected.\n", inputMethod);

                int myArray[] = {5, 2, 1, 9, 7};

                // Sort the array in descending order.
                Integer[] tempArray = Arrays.stream(myArray).boxed().toArray(Integer[]::new);
                Arrays.sort(tempArray, Collections.reverseOrder());

                System.out.println(Arrays.toString(tempArray));
                break;
            }
            // Method 3: int Array: Use negative values and flip after sorting.
            else if (inputMethod == 3) {
                System.out.printf("Method [%d] selected.\n", inputMethod);

                int myArray[] = {-5, -2, -1, -9, -7};

                // Sort the array in descending order.
                Arrays.sort(myArray);
                for (int i = 0; i < myArray.length; i++) {
                    myArray[i] = -myArray[i];
                }

                System.out.println(Arrays.toString(myArray));
                break;
            }
            else {
                System.out.println("Please enter a valid option (1 ~ 3).\n");
            }
        }
        System.out.println();
    }
}
