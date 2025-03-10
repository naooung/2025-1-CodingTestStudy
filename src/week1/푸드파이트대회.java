package week1;

import java.util.Stack;

public class 푸드파이트대회 {
    public String solution(int[] food) {
        // 1. StringBuilder와 Stack 생성
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        // 2. 왼쪽 부분
        for (int i = 1; i < food.length; i++) {
            int num = food[i] / 2;
            if (num != 0) {
                for (int j = 0; j < num; j++) {
                    String s = Integer.toString(i);
                    sb.append(s);
                    stack.push(s);
                }
            }
        }

        // 3. 중간 부분
        sb.append("0");

        // 4. 오른쪽 부분
        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString();
    }
}