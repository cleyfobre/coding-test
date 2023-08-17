package dfsbfs;

import java.util.*;

// 단지 수 찾기
public class Baekjoon2667apt {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int n;
    static int[][] a;
    static boolean[][] visited;
    static ArrayList<Integer> complex = new ArrayList<>();

    // 맵 안에 있는지
    public static boolean valid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void dfs(int x, int y, int cnt) {  // 단지 찾기
        visited[x][y] = true;
        complex.set(cnt, complex.get(cnt) + 1);

        // 상하좌우 총 4번 탐색
        for (int k = 0; k < 4; ++k) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            // 맵 안에 있고, 방문한 적 없고, 1인지
            if (valid(nx, ny) && !visited[nx][ny] && a[nx][ny] == 1)
                dfs(nx, ny, cnt);
        }
    }

    public static void bfs(int x, int y, int cnt, ArrayList<Integer> complex) {  // 단지 찾기
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        complex.set(cnt, complex.get(cnt) + 1);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int k = 0; k < 4; ++k) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if (valid(nx, ny) && !visited[nx][ny] && a[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    complex.set(cnt, complex.get(cnt) + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        a = new int[n][n];
        visited = new boolean[n][n];

        // 주어진 지도 입력 받기
        for (int i = 0; i < n; ++i) {
            String line = sc.next();
            for (int j = 0; j < n; ++j) {
                a[i][j] = line.charAt(j) - '0';
            }
        }

        // 단지의 개수를 저장하는 ArrayList 초기화
        complex = new ArrayList<>(Collections.nCopies(n*n,0));

        // dfs 탐색으로 단지 찾기
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                // 방뭄한적 없고 1이면
                if (!visited[i][j] && a[i][j] == 1) {
                     dfs(i, j, cnt++);
//                     bfs(i, j, cnt++, complex);
                }
            }
        }

        // 단지의 개수 출력
        System.out.println(cnt);

        // 단지 별 집의 수를 오름차순으로 정렬하여 출력
        Collections.sort(complex.subList(0,cnt));
        for (int i = 0; i < cnt; ++i) {
            System.out.println(complex.get(i));
        }
    }
}
