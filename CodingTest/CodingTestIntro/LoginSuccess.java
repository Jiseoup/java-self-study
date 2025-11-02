// [Lv.0] 로그인 성공?

package CodingTest.CodingTestIntro;

import java.util.*;

public class LoginSuccess {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase(new String[] { "meosseugi", "1234" },
                        new String[][] { { "rardss", "123" }, { "yyoom", "1234" }, { "meosseugi", "1234" } }),
                new TestCase(new String[] { "programmer01", "15789" },
                        new String[][] { { "programmer02", "111111" }, { "programmer00", "134" },
                                { "programmer01", "1145" } }),
                new TestCase(new String[] { "rabbit04", "98761" },
                        new String[][] { { "jaja11", "98761" }, { "krong0313", "29440" }, { "rabbit00", "111333" } }),
                new TestCase(new String[] { "meosseugi", "1234" },
                        new String[][] { { "meosseugi", "1234" }, { "rardss", "123" }, { "yyoom", "1234" } }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            String result = sol.solution(t.id_pw, t.db);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    String[] id_pw;
    String[][] db;

    TestCase(String[] id_pw, String[][] db) {
        this.id_pw = id_pw;
        this.db = db;
    }
}

class Solution {
    final String LOGIN = "login";
    final String FAIL = "fail";
    final String WRONG_PASSWORD = "wrong pw";

    public String solution(String[] id_pw, String[][] db) {
        String id = id_pw[0];
        String pwd = id_pw[1];

        for (String[] account : db) {
            String db_id = account[0];
            String db_pwd = account[1];

            if (id.equals(db_id) && pwd.equals(db_pwd))
                return LOGIN;
            else if (id.equals(db_id) && !pwd.equals(db_pwd))
                return WRONG_PASSWORD;
        }

        return FAIL;
    }
}