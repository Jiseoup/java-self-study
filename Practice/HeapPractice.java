package Practice;

import java.util.*;

public class HeapPractice {
    public static void main(String[] args) {
        // 최소 힙: 기본 정렬
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(8);
        System.out.printf("우선 순위 큐: %s\n", minHeap);
        System.out.printf("최소 힙: %d\n", minHeap.peek());

        // 최대 힙: 역 정렬
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(5);
        maxHeap.add(3);
        maxHeap.add(1);
        maxHeap.add(8);
        System.out.printf("우선 순위 큐: %s\n", maxHeap);
        System.out.printf("최대 힙: %d\n", maxHeap.peek());
    }
}
