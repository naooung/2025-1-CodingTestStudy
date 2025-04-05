package week3;

import java.util.*;

public class 헌내기는친구가필요해 {
  static int n;
  static int m;
  static char[][] campus;
  static int[][] visited;
  static int count;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    campus = new char[n][m];
    visited = new int[n][m];

    // 캠퍼스의 정보와 현재 도연이의 위치 저장
    int[] i = new int[2];
    for (int x = 0; x < n; x++) {
      String s = sc.next();
      for (int y = 0; y < m; y++) {
        char c = s.charAt(y);
        campus[x][y] = c;
        if (c == 'I') {
          i[0] = x; i[1] = y;
        }
      }
    }

    // 깊이 우선 탐색을 사용하여 P 개수 카운팅
    count = 0;
    dfs(i[0], i[1]);

    System.out.println((count == 0) ? "TT" : count);
  }

  static public void dfs(int x, int y) {
    visited[x][y] = 1;
    if (campus[x][y] == 'P')
      count++;

    // 상하좌우가 조건(캠퍼스 번위 내, 방문하지 않음, 벽이 아님)에 맞으면 깊이 탐색 진행
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    for (int i = 0; i < 4; i++) {
      int newx = x + dx[i];
      int newy = y + dy[i];

      if (newx < 0 || newy < 0 || newx >= n || newy >= m
          || visited[newx][newy] == 1 || campus[newx][newy] == 'X') {
        continue;
      }
      dfs(newx, newy);
    }
  }
}
