package week2;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        // 제일 긴 변을 고정
        int longest = 0;
        int longestRow = 0;
        int longestCol = 0;
        for (int i = 0; i < sizes.length; i++)
            for (int j = 0; j < 2; j++)
                if (longest < sizes[i][j]) {
                    longest = sizes[i][j];
                    longestRow = i;
                    longestCol = j;
                }
        // 해당 사각형의 다른 변 길이 vs 다른 사각형의 작은 변 길이 (큰 변은 제일 긴 변에 맞춤)
        int anotherCol = (longestCol == 0) ? 1 : 0;
        int another = sizes[longestRow][anotherCol];
        for (int i = 0; i < sizes.length; i++) {
            int small = (sizes[i][0] > sizes[i][1]) ? sizes[i][1] : sizes[i][0];
            if (small > another)
                another = small;
        }

        return longest * another;
    }
}
