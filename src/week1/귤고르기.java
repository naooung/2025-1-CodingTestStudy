package week1;

import java.util.*;

public class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        // 1. [귤의 크기, 개수]를 저장하기 위한 map 생성
        HashMap<Integer, Integer> map = new HashMap<>();

        // 2. 귤의 크기마다 개수를 세어 map에 저장
        for (int i = 0; i < tangerine.length; i++) {
            int t = tangerine[i];

            if (map.containsKey(t))
                map.replace(t, map.get(t) + 1);
            else
                map.put(t, 1);
        }

        // 3. map의 value에 따라 내림차순 정렬
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());

        // 4. 개수가 큰 것부터 귤 담기 (종료 조건: k가 0보다 작을 때)
        int kind = 0;
        for (int i = 0; i < list.size(); i++) {
            k -= list.get(i);
            kind++;

            if (k <= 0)
                break;
        }

        return kind;
    }
}
