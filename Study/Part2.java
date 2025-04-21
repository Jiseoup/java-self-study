// Part 2. Scanner vs BufferedReader

// 코딩 테스트: 대체로 `BufferedReader`가 더 좋음.
// >> 빠른 입출력 속도로, 제한 시간의 한계를 극복하기 좋음.

/**
 * Scanner 메서드 `next()`와 `nextLine()`의 차이
 * 1. `next()`:
 *      - 버퍼에 입력된 공백(스페이스, 탭, 개행) 전까지의 문자열을 읽음
 *      - 개행 문자 무시하고 처리
 * 2. `nextLine()` :
 *      - 버퍼에 입력된 문자열을 모두 읽음
 *      - 개행 문자 포함하여 처리
 */

package Study;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Part2 {
    public static void main(String[] args) throws Exception {
        try {
            IOExample.runScanner();
            IOExample.runBufferedReader();
            IOExample.runStringTokenizer();
        }
        catch (IOException e) {
            System.out.println("Input error: " + e.getMessage());
            throw e;
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
            throw e;
        }
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
            throw e;
        }
    }
}


class IOExample {
    // 1. Scanner Example.
    public static void runScanner() {
        System.out.println("[Scannner Example]");

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Example of `next()` method.
        System.out.print("(1) Input integer: ");
        int x = scanner.nextInt();
        System.out.print("(2) Input string: ");
        String y = scanner.next();
        System.out.print("(3) Input string: ");
        String z = scanner.next();

        System.out.printf("[OutPut]\n(1) %d\n(2) %s\n(3) %s\n", x, y, z);
        System.out.println("-----------------------------------------");

        // Empty Buffer.
        scanner.nextLine();

        // Example of `nextLine()` method.
        System.out.print("(1) Input line: ");
        String a = scanner.nextLine();
        System.out.print("(2) Input line: ");
        String b = scanner.nextLine();

        System.out.printf("[OutPut]\n(1) %s\n(2) %s\n", a, b);
    }

    // 2. BufferedReader Example.
    public static void runBufferedReader() throws Exception {
        System.out.println("[BufferedReader Example]");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // I/O examples with BufferedReader.
        try {
            System.out.print("Enter the item: ");
            String item = br.readLine();

            System.out.print("Enter the amount: ");
            int amount = Integer.parseInt(br.readLine());

            System.out.printf("[My Order]\n%s x %d\n", item, amount);
        }
        catch (Exception e) {
            throw e;
        }
    }

    // 3. StringTokenizer Example.
    public static void runStringTokenizer() throws Exception {
        System.out.println("[StringTokenizer Example]");

        // I/O examples with BufferedReader and StringTokenizer.
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Input two words separated by a hypen(-): ");

            // Read a line of input and split it by the hyphen delimiter.
            StringTokenizer st = new StringTokenizer(br.readLine(), "-");
            String firstWord = st.nextToken();
            String secondWord = st.nextToken();

            System.out.printf("[Split the words]\n%s / %s\n", firstWord, secondWord);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
