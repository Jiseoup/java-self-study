package CodingTest.PCCE;

import java.util.List;

public class Problem8 {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
            new TestCase(
                new String[] {"pencil", "pencil", "pencil", "book"},
                new int[] {2, 4, 3, 1}
            ),
            new TestCase(
                new String[] {"doll", "doll", "doll", "doll"},
                new int[] {1, 1, 1, 1}
            ),
            new TestCase(
                new String[] {"apple", "steel", "leaf", "apple", "leaf"},
                new int[] {5, 3, 5, 3, 7}
            ),
            new TestCase(
                new String[] {"mirror", "net", "mirror", "net", "bottle"},
                new int[] {4, 1, 4, 1, 5}
            )
        );

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            String result = sol.solution(t.storage, t.num);
            System.out.println(result);
        }
    }
}


// Create TestCase
class TestCase {
    String[] storage;
    int[] num;

    TestCase(String[] storage, int[] num) {
        this.storage = storage;
        this.num = num;
    }
}


class Solution {
    public String solution(String[] storage, int[] num) {
        int num_item = 0;
        String[] clean_storage = new String[storage.length];
        int[] clean_num = new int[num.length];

        for(int i=0; i<storage.length; i++){
            int clean_idx = -1;
            for(int j=0; j<num_item; j++){
                if(storage[i].equals(clean_storage[j])){
                    clean_idx = j;
                    break;
                }
            }
            if(clean_idx == -1){
                clean_storage[num_item] = storage[i];
                clean_num[num_item] = num[i];
                num_item += 1;
            }
            else{
                clean_num[clean_idx] += num[i];
            }
        }

        int num_max = -1;
        String answer = "";
        for(int i=0; i<num_item; i++){
            if(clean_num[i] > num_max){
                num_max = clean_num[i];
                answer = clean_storage[i];
            }
        }
        return answer;
    }
}
