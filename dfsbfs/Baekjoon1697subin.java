package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1697subin {

    static int N, K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        br.close();

        int result = bfs(N, K);
        System.out.println(result);
    }

    static int bfs(int subin, int sister) {
        Queue<Integer> q = new LinkedList<>();
        q.add(subin);
        visited[subin] = 0;

        while(!q.isEmpty()) {
            int current = q.poll();

            if(current == sister) {
                return visited[current];
            }

            if(current-1 >= 0 && visited[current-1] == 0) {
                q.add(current-1);
                visited[current-1] = visited[current]+1;
            }
            if(current+1 <= 100000 && visited[current+1] == 0) {
                q.add(current+1);
                visited[current+1] = visited[current]+1;
            }
            if(current*2 <= 100000 && visited[current*2] == 0) {
                q.add(current*2);
                visited[current*2] = visited[current];
            }
        }
        return 0;
    }

}
