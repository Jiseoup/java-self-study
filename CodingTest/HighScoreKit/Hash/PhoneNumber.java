// [Lv.2] 전화번호 목록

package CodingTest.HighScoreKit.Hash;

import java.util.*;

public class PhoneNumber {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new String[] { "119", "97674223", "1195524421" }),
                new TestCase(new String[] { "123", "456", "789" }),
                new TestCase(new String[] { "12", "123", "1235", "567", "88" }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            boolean result = sol.solution(t.phone_book);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    String[] phone_book;

    TestCase(String[] phone_book) {
        this.phone_book = phone_book;
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        // Sort to group strings with similar prefixes together.
        Arrays.sort(phone_book);

        // Check adjacent pairs for prefix matches.
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i]))
                return false;
        }
        return true;
    }
}