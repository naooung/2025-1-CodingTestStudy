package week2;

import java.util.*;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        // 우선순위 큐로 우선순위가 높은 것부터 정렬
        // 기존 큐에서 우선순위큐 맨처음 값이랑 같으면 삭제 아니면 다시 큐에 넣기
        // + 우선순위 큐에서도 삭제
        // 해당 프로세스가 언제 실행되는지 확인 방법:
        // 해당 프로세스의 인덱스를 계속 기록하여(꺼낼 때마다 -1, 0이되면 다시 맨뒤 size-1)
        // 프로세스가 삭제될 때 인덱스가 0인지 확인
        int index = location;
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
            q.offer(priorities[i]);
        }

        while (!q.isEmpty()) {
            int p = q.poll();
            if (p == pq.peek()) { // 우선 순위가 제일 높은 프로세스라면
                count++;
                if (index == 0) // 목표 프로세스가 꺼내졌다면
                    break;
                pq.poll();
            }
            else
                q.offer(p);
            index--; // 목표 프로세스 인덱스 재조정
            if (index < 0) // 인덱스가 0보다 작아지면 현재 프로세스 개수 맨 마지막으로 넣기
                index = q.size() - 1;
        }

        return count;
    }
}
