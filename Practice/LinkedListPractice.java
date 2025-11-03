package Practice;

import java.util.*;

public class LinkedListPractice {
    public static void main(String[] args) {
        /*
         * 1. Queue -> 주로 add(), poll() 사용.
         * 2. Stack -> 주로 push(), pop() 사용.
         * 3. Deque -> Queue + Stack 모두 사용.
         */
        int[] numberArray = { 3, 2, 1, 5, 4, 8, 6, 9, 7 };

        // 리스트 초기화.
        LinkedList<Integer> list = new LinkedList<>();
        for (int number : numberArray) {
            list.add(number);
        }
        System.out.printf("원본 리스트: %s\n", list);

        // 리스트 오름차순 정렬.
        Collections.sort(list);
        System.out.printf("오름차순 정렬: %s\n", list);

        // 리스트 내림차순 정렬.
        Collections.sort(list, (a, b) -> b - a);
        System.out.printf("내림차순 정렬: %s\n", list);

        // 리스트 맨 앞에 요소 추가.
        list.addFirst(10);
        System.out.printf("요소가 추가된 리스트: %s\n", list);

        // Peek() Methods: 요소 검색과 반환 (제거 X, 빈 리스트: null 반환).
        int peek1 = list.peek();
        int peek2 = list.peekFirst();
        int peek3 = list.peekLast();
        System.out.printf("peek1=%d, peek2=%d, peek3=%d, 리스트: %s\n", peek1, peek2, peek3, list);

        // Poll() Methods: 요소 검색과 반환 (제거 O, 빈 리스트: null 반환).
        int poll1 = list.poll();
        int poll2 = list.pollFirst();
        int poll3 = list.pollLast();
        System.out.printf("poll1=%d, poll2=%d, poll3=%d, 리스트: %s\n", poll1, poll2, poll3, list);

        // Remove() Methods: 요소 검색과 반환 (제거 O, 빈 리스트: 예외 발생).
        int remove1 = list.remove();
        int remove2 = list.removeFirst();
        int remove3 = list.removeLast();
        int remove4 = list.remove(1);
        System.out.printf("remove1=%d, remove2=%d, remove3=%d, remove4=%d, 리스트: %s\n", remove1, remove2, remove3,
                remove4, list);

        // Pop() Method: 맨 앞 요소 제거 및 반환.
        int pop = list.pop();
        System.out.printf("pop=%d, 리스트: %s\n", pop, list);

        // Push() Method: 맨 앞에 요소 추가.
        list.push(1);
        System.out.printf("리스트: %s\n", list);
    }
}
