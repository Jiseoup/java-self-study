// Part 7. for vs while

package Study;

import java.util.UUID;
import java.util.Random;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;


public class Part07 {
    public static void main(String[] args) {
        try {
            LoopExample.runFor();
            LoopExample.runWhile();
        }
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}


enum Job {
    WARRIOR, ARCHER, WIZARD, THIEF;

    private static final Job[] VALUES = values();
    private static final Random RANDOM = new Random();

    public static Job getRandomJob() {
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }
}


class CharacterInfo {
    String uid;
    String name;
    Job job;
    int level;

    public CharacterInfo(String name) {
        this.uid = UUID.randomUUID().toString();
        this.name = name;
        this.job = Job.getRandomJob();
        this.level = new Random().nextInt(100) + 1;
    }
}


class LoopExample {
    // 1. For Loop Example.
    public static void runFor() throws Exception {
        System.out.println("[For Loop Example]");

        // Create userList.
        List<CharacterInfo> userList = new ArrayList<>(
            List.of(
                new CharacterInfo("Atlas"),
                new CharacterInfo("King"),
                new CharacterInfo("Comet"),
                new CharacterInfo("Eclipse"),
                new CharacterInfo("Ghost"),
                new CharacterInfo("Faker"),
                new CharacterInfo("Ambition"),
                new CharacterInfo("Leonard"),
                new CharacterInfo("Owen")
            )
        );
        // Sort the userList in descending order by level.
        userList.sort(Comparator.comparingInt((CharacterInfo c) -> c.level).reversed());

        for (Job jobType : Job.values()) {
            System.out.printf("{ %s }\n", jobType);
            boolean hasCharacter = false;

            // Print user info grouped by job type.
            for (CharacterInfo c : userList) {
                if (c.job == jobType) {
                    System.out.printf("Name: %s, Level: %d - %s\n", c.name, c.level, c.uid);
                    hasCharacter = true;
                }
            }

            // If the Job doesn't include any Character, print "None".
            if (!hasCharacter) {
                System.out.println("None");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 2. While Loop Example.
    public static void runWhile() throws Exception {
        System.out.println("[While Loop Example]");

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(10);
        queue.add(5);
        queue.add(4);

        // Print the value of the queue until it is empty.
        while (!queue.isEmpty()) {
            int value = queue.poll();

            // If the value is even, divide it by 2 and add it to the queue.
            if (value % 2 == 0) {
                queue.add(value / 2);
            }
            System.out.print(value + " ");
        }

        System.out.println();
    }
}
