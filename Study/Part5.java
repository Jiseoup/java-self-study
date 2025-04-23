// Part 5. Comparable

// Comparable : 정렬 기준이 여러 개일 때 사용.
// >> 오름차순(ASC) : `compareTo()` 에서 매개변수 데이터가 더 클 때 (음수 리턴).
// >> 내림차순(DESC) : `compareTo()` 에서 매개변수 데이터가 더 작을 때 (양수 리턴).

/**
 * First Example: 학생의 영어 점수 순위 출력
 *  1. 영어 점수가 높은 순으로 정렬.
 *  2. 영어 점수가 같은 경우, 수학 점수가 높은 순으로 정렬.
 * 
 * Second Example: 생일을 보고 나이 순서대로 출력
 *  1. 생일이 작은 순으로 정렬. (나이 많은 순으로 출력)
 *  2. 생일이 같을 경우, 이름 순서대로 정렬. (알파벳 순)
 *  3. 생일과 이름이 모두 같을 경우, 직업 순서대로 정렬. (알파벳 순)
 */

package Study;

import java.time.Period;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;


public class Part5 {
    public static void main(String[] args) {
        try {
            ComparableExample.runFirstExample();
            ComparableExample.runSecondExample();
        }
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}


// Student Class for First Example.
class Student implements Comparable<Student> {
    String name;
    int english;
    int math;

    public Student(String name, int english, int math) {
        super();
        this.name = name;
        this.english = english;
        this.math = math;
    }

    @Override
    public String toString() {
        String result = String.format("%s [English: %d, Math: %d]", name, english, math);
        return result;
    }

    @Override
    public int compareTo(Student student) {
        // If English scores are same.
        if (this.english == student.english) {
            // Order by math in descending order.
            return student.math - this.math;
        }
        // Order by english in descending order.
        return student.english - this.english;
    }
}


class Person implements Comparable<Person> {
    String name;
    String job;
    LocalDate birthday;
    // int age;

    public Person(String name, String job, LocalDate birthday) {
        super();
        this.name = name;
        this.job = job;
        this.birthday = birthday;
        /* CASE 1: Calculate Korean age in the structure. */
        // this.age = Period.between(birthday, LocalDate.now()).getYears() + 1;
    }

    @Override
    public String toString() {
        /* CASE 2: Calculate Korean age when converting to string. */
        int age = Period.between(birthday, LocalDate.now()).getYears() + 1;

        return String.format("[%s] %s : %s (%d years old)", birthday, name, job, age);
    }

    @Override
    public int compareTo(Person person) {
        // If Birthday and Name are same.
        if (this.birthday.equals(person.birthday) && this.name.equals(person.name)) {
            // Order by job in ascending order.
            return this.job.compareTo(person.job);
        }
        // If Birthdays are same.
        else if (this.birthday.equals(person.birthday)) {
            // Order by name in ascending order.
            return this.name.compareTo(person.name);
        }
        else {
            // Order by birthday in ascending order.
            return this.birthday.compareTo(person.birthday);
        }
    }
}


class ComparableExample {
    public static void runFirstExample() throws Exception {
        /**
         * Conditions
         *  1. Sort scores in descending order based on English scores.
         *  2. If English scores are same, sort in descending order based on Math scores.
         */
        System.out.println("[First Comparable Example]\n");

        ArrayList<Student> ranking = new ArrayList<>();

        ranking.add(new Student("Albert", 80, 100));
        ranking.add(new Student("John", 100, 100));
        ranking.add(new Student("Amy", 70, 80));
        ranking.add(new Student("Michelle", 100, 90));

        Collections.sort(ranking);

        System.out.println("[Student English Ranking]");
        for (int i = 0; i < ranking.size(); i++) {
            System.out.printf("(%d) %s\n", i + 1, ranking.get(i).toString());
        }
        System.out.println();
    }

    public static void runSecondExample() throws Exception {
        /**
         * Conditions
         *  1. Sort ages in descending order based on Birthday.
         *  2. If Birthdays are same, sort in descending order based on Name. (Alphabetically)
         *  3. If Birthday and Name are same, sort in descending order based on Job. (Alphabetically)
         */
        System.out.println("[Second Comparable Example]\n");

        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Jake", "Designer", LocalDate.of(1997, 3, 20)));
        people.add(new Person("Sally", "Engineer", LocalDate.of(2000, 4, 29)));
        people.add(new Person("Jake", "Engineer", LocalDate.of(1997, 3, 20)));
        people.add(new Person("Tom", "Designer", LocalDate.of(1992, 5, 12)));
        people.add(new Person("James", "Chef", LocalDate.of(1995, 4, 3)));
        people.add(new Person("Michael", "Singer", LocalDate.of(1997, 3, 20)));
        people.add(new Person("Jayden", "Engineer", LocalDate.of(1998, 1, 26)));

        Collections.sort(people);

        System.out.println("[List of the People]");
        for (int i = 0; i < people.size(); i++) {
            System.out.printf("(%d) %s\n", i + 1, people.get(i).toString());
        }

        System.out.println();
    }
}
