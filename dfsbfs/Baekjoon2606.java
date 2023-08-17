package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2606 {

    static int n;
    static int e;
    static boolean[] visited;
    static int[][] edges;

    private static void dfs(int c) {
        visited[c] = true;
        // System.out.print(c + " ");

        for (int i = 1; i <= n; i++) {
            if (edges[c][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        edges = new int[n+1][n+1];

        e = Integer.parseInt(br.readLine());
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            edges[c][r] = 1;
            edges[r][c] = 1;
        }

        dfs(1);

        // 1번 자기 자신은 빼기
        int cnt = -1;
        for (boolean v: visited) {
            if (v) cnt++;
        }

        System.out.println(cnt);

//        dfs(0, rooms);

    }

}
