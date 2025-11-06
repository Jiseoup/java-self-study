// [Lv.1] 개인정보 수집 유효기간

package CodingTest.KakaoBlindRecruitment2023;

import java.util.*;

public class PersonalInformation {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(
                        "2022.05.19",
                        new String[] { "A 6", "B 12", "C 3" },
                        new String[] { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" }),
                new TestCase(
                        "2020.01.01",
                        new String[] { "Z 3", "D 5" },
                        new String[] { "2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D",
                                "2018.12.28 Z" }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            int[] result = sol.solution(t.today, t.terms, t.privacies);
            System.out.println(Arrays.toString(result));
        }
    }
}

// Create TestCase
class TestCase {
    String today;
    String[] terms;
    String[] privacies;

    TestCase(String today, String[] terms, String[] privacies) {
        this.today = today;
        this.terms = terms;
        this.privacies = privacies;
    }
}

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> removeList = new ArrayList<Integer>();

        // Convert today to int days.
        int intToday = convertToDays(today);

        // Create HashMap for store terms name and months.
        Map<String, Integer> termsMap = new HashMap<String, Integer>();
        for (String term : terms) {
            String name = term.split(" ")[0];
            int month = Integer.parseInt(term.split(" ")[1]);
            termsMap.put(name, month);
        }

        // Find terms to remove.
        for (int i = 0; i < privacies.length; i++) {
            int date = convertToDays(privacies[i].split(" ")[0]);
            String term = privacies[i].split(" ")[1];

            int validDate = date + (termsMap.get(term) * 28) - 1;

            if (intToday > validDate) {
                removeList.add(i + 1);
            }
        }

        int[] answer = removeList.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    // Function for convert `yyyy.mm.dd` format to int days.
    private static int convertToDays(String date) {
        String[] dateList = date.split("\\.");

        int year = Integer.parseInt(dateList[0]);
        int month = Integer.parseInt(dateList[1]);
        int day = Integer.parseInt(dateList[2]);

        int days = day + (month * 28) + (year * 12 * 28);

        return days;
    }
}
