package week2;

import java.util.*;

public class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        // n번째 문자가 같은 문자열 정렬 선 + n번째 문자 비교하여 내림차순 정렬
        Arrays.sort(strings);
        Arrays.sort(strings, (o1, o2) -> (o1.charAt(n) - o2.charAt(n)));

        return strings;
    }
}
