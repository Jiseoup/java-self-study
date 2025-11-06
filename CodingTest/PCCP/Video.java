// [Lv.1] 동영상 재생기

package CodingTest.PCCP;

import java.util.*;

public class Video {
    public static void main(String[] args) {
        // Examples
        List<TestCase> testCases = List.of(
                new TestCase("34:33", "13:00", "00:55", "02:55", new String[] { "next", "prev" }),
                new TestCase("10:55", "00:05", "00:15", "06:55", new String[] { "prev", "next", "next" }),
                new TestCase("07:22", "04:05", "00:15", "04:07", new String[] { "next" }));

        // Solutions
        Solution sol = new Solution();
        for (TestCase t : testCases) {
            String result = sol.solution(t.video_len, t.pos, t.op_start, t.op_end, t.commands);
            System.out.println(result);
        }
    }
}

// Create TestCase
class TestCase {
    String video_len;
    String pos;
    String op_start;
    String op_end;
    String[] commands;

    TestCase(String video_len, String pos, String op_start, String op_end, String[] commands) {
        this.video_len = video_len;
        this.pos = pos;
        this.op_start = op_start;
        this.op_end = op_end;
        this.commands = commands;
    }
}

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // Convert string to int seconds.
        int videoLenSecond = toIntSeconds(video_len);
        int posSecond = toIntSeconds(pos);
        int opStartSecond = toIntSeconds(op_start);
        int opEndSecond = toIntSeconds(op_end);

        // Loop commands.
        for (String command : commands) {
            // Skip opening.
            posSecond = skipOpening(posSecond, opStartSecond, opEndSecond);

            // Process command.
            if (command.equals("prev"))
                posSecond = Math.max(posSecond - 10, 0);
            else
                posSecond = Math.min(posSecond + 10, videoLenSecond);
        }

        // Skip opening at the last time.
        posSecond = skipOpening(posSecond, opStartSecond, opEndSecond);

        return toStringTime(posSecond);
    }

    // Skip opening when condition(start <= pos <= end) matches.
    private int skipOpening(int pos, int start, int end) {
        return start <= pos && pos <= end ? end : pos;
    }

    // Convert string time("MM:SS") to int seconds.
    private int toIntSeconds(String time) {
        String[] timeArray = time.split(":");
        int minute = Integer.parseInt(timeArray[0]);
        int second = Integer.parseInt(timeArray[1]);
        return minute * 60 + second;
    }

    // Convert int seconds to string time.
    private String toStringTime(int time) {
        int minute = time / 60;
        int second = time % 60;
        return String.format("%02d:%02d", minute, second);
    }
}