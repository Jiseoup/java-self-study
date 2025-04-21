package CodingTest.PCCE;

import java.util.List;

public class Problem7 {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
            new TestCase("auto", 23, 45),
            new TestCase("target", 41, 40),
            new TestCase("minimum", 10, 34)
        );

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int result = sol.solution(t.mode, t.humidity, t.value);
            System.out.println(result);
        }
    }
}


// Create TestCase
class TestCase {
    String mode;
    int humidity;
    int value;

    TestCase(String mode_type, int humidity, int val_set) {
        this.mode = mode_type;
        this.humidity = humidity;
        this.value = val_set;
    }
}


class Solution {
    public int func1(int humidity, int val_set){
        if(humidity < val_set)
            return 3;
        return 1;
    }

    public int func2(int humidity){
        if(humidity >= 50)
            return 0;
        else if (humidity >= 40)
            return 1;
        else if (humidity >= 30)
            return 2;
        else if (humidity >= 20)
            return 3;
        else if (humidity >= 10)
            return 4;
        else
            return 5;
    }

    public int func3(int humidity, int val_set){
        if(humidity < val_set)
            return 1;
        return 0;
    }

    public int solution(String mode_type, int humidity, int val_set) {
        int answer = 0;

        if(mode_type.equals("auto")){
            answer = func2(humidity);
        }
        else if(mode_type.equals("target")){
            answer = func1(humidity, val_set);
        }
        else if(mode_type.equals("minimum")){
            answer = func3(humidity, val_set);
        }

        return answer;
    }
}
