package dfsbfs;

import java.util.*;

public class Baekjoon1260 {
    static int n, m, v;
    static int[][] a;
    static boolean[] visited;

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i <= n; ++i) {
            if (a[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            for (int i = 1; i <= n; ++i) {
                if (a[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        n = input.charAt(0) - '0';
        m = input.charAt(1) - '0';
        v = input.charAt(2) - '0';

        a = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        // 간선 정보 입력 받기
        for (int i = 0; i < m; ++i) {
            String vInput = sc.next();
            int u = vInput.charAt(0) - '0';
            int v = vInput.charAt(1) - '0';
            a[u][v] = a[v][u] = 1;
        }

        dfs(v);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(v);
    }
}
