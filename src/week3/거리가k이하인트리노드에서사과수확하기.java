package week3;

import java.util.*;

public class 거리가k이하인트리노드에서사과수확하기 {
  static int n;
  static int k;
  static Node[] nodes;
  static int count;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    k = sc.nextInt();
    // n개의 노드 생성
    nodes = new Node[n];
    for (int i = 0; i < n; i++)
      nodes[i] = new Node();

    // 간선 정보 저장
    for (int i = 0; i < n - 1; i++) {
      int parent = sc.nextInt();
      int child = sc.nextInt();
      nodes[parent].addChild(child);
    }

    // 정점 순서대로 사과 여부 저장
    for (int i = 0; i < n; i++)
      nodes[i].apple = sc.nextInt();

    // 루트 노드부터 시작해서 길이가 k 이하인 트리 탐색
    count = 0;
    dfs(0, 0);

    System.out.println(count);
  }

  static void dfs(int node, int length) {
    // 해당 노드에 사과 확인
    if (nodes[node].apple == 1)
      count++;

    // 길이 조건 확인 후 자식 노드로 깊이 탐색 진행
    if (length == k)
      return;
    else
      for (int i = 0; i < nodes[node].child.size(); i++)
        dfs(nodes[node].child.get(i), length + 1);
  }

  static class Node {
    ArrayList<Integer> child;
    int apple;

    public Node() {
      child = new ArrayList<>();
      apple = 0;
    }

    public void addChild(int child) {
      this.child.add(child);
    }

    public void setApple(int apple) {
      this.apple = apple;
    }
  }
}
