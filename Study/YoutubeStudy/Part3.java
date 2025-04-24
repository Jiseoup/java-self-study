// Part 3. ++i vs i++

// 전위연산자 (++i) : i 변수의 증감 이후, 다른 연산을 수행.
// 후위연산자 (i++) : 다른 연산을 먼저 수행한 후, i 변수를 증감.

package Study.YoutubeStudy;


public class Part3 {
    public static void main(String[] args) {
        try {
            OperatorExample.runPrefix();
            OperatorExample.runPostfix();
        }
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}


class OperatorExample {
    // 1. Prefix Operator Example.
    public static void runPrefix() throws Exception {
        System.out.println("[Prefix Operator Example]");

        int i = 1;
        int Array[] = new int[3];

        Array[0] = 5;
        Array[++i] = 10;
        
        System.out.printf(
            "i: %d / Array[0]: %d / Array[1]: %d / Array[2]: %d\n",
            i, Array[0], Array[1], Array[2]
        );
        System.out.println();
    }

    // 2. Postfix Operator Example.
    public static void runPostfix() throws Exception {
        System.out.println("[Postfix Operator Example]");

        int i = 1;
        int Array[] = new int[3];

        Array[0] = 5;
        Array[i++] = 10;
        
        System.out.printf(
            "i: %d / Array[0]: %d / Array[1]: %d / Array[2]: %d\n",
            i, Array[0], Array[1], Array[2]
        );
        System.out.println();
    }
}
