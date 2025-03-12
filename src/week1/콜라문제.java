package week1;

public class 콜라문제 {
    public int solution(int a, int b, int n) {
        int result = 0;

        while (n >= a) {
            // 교환한 콜라 계산
            int get = (n / a) * b;
            result += get;

            // 교환하지 못한 콜라 계산
            int left = n % a;

            // 교환한 콜라 + 남은 콜라
            n = get + left;
        }

        return result;
    }
}
