// Part 8. if vs switch

package Study.YoutubeStudy;

import java.util.ArrayList;
import java.util.Scanner;


public class Part08 {
    public static void main(String[] args) {
        try {
            ConditionExample.runIf();
            ConditionExample.runSwitch();
        }
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}


class Student {
    String name;
    int score;
    Character grade;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}


class ConditionExample {
    private static ArrayList<Student> students = new ArrayList<>();

    // 1. If Condition Example.
    public static void runIf() throws Exception {
        System.out.println("[If Condition Example]");

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.printf("Student %d Name: ", i + 1);
            String name = scanner.next();

            System.out.printf("Student %d Score (0~100): ", i + 1);
            int score = scanner.nextInt();
            if ((score < 0) || (score > 100)) {
                throw new IllegalArgumentException("Score must be between 0 and 100.");
            }

            students.add(new Student(name, score));
            System.out.println();
        }

        for (Student student : students) {
            if (student.score >= 90) {
                student.grade = 'A';
            }
            else if (student.score >= 75) {
                student.grade = 'B';
            }
            else if (student.score >= 60) {
                student.grade = 'C';
            }
            else if (student.score >= 45) {
                student.grade = 'D';
            }
            else {
                student.grade = 'F';
            }
            System.out.printf(
                "[Student: %s] Grade: %c, Score: %d\n",
                student.name, student.grade, student.score
            );
        }
        System.out.println();
    }

    // 2. Switch Condition Example.
    public static void runSwitch() throws Exception {
        System.out.println("[Switch Condition Example]");

        while (!students.isEmpty()) {
            Student student = students.remove(0);

            switch (student.grade) {
                case 'A':
                    System.out.printf("Perfect! You achieved \"A\" grade %s!\n", student.name);
                    break;
                case 'B':
                    System.out.printf("Great! You achieved \"B\" grade %s!\n", student.name);
                    break;
                case 'C':
                    System.out.printf("Good. You achieved \"C\" grade %s.\n", student.name);
                    break;
                case 'D':
                    System.out.printf("Oops.. You achieved \"D\" grade %s.\n", student.name);
                    break;
                default:
                    System.out.printf("Oh no.. You achieved \"F\" grade %s...\n", student.name);
                    break;
            }
        }
        System.out.println();
    }
}
