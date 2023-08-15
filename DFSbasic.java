import java.util.ArrayList;
import java.util.Arrays;

public class DFSbasic {

    static ArrayList<Integer>[] graph; // 그래프를 인접 리스트로 표현
    static boolean[] visited; // 노드의 방문 여부를 나타내는 배열

    public static void dfs(int node) {
        visited[node] = true; // 현재 노드를 방문 처리
        System.out.print(node + " "); // 현재 노드 출력

        for (int next : graph[node]) { // 현재 노드와 연결된 인접 노드들을 방문
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        int n = 8; // 노드의 수
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 초기화
        graph[1].add(2);
        graph[1].add(3);
        graph[1].add(8);
        graph[2].add(1);
        graph[2].add(7);
        graph[3].add(1);
        graph[3].add(4);
        graph[3].add(5);
        graph[4].add(3);
        graph[4].add(5);
        graph[5].add(3);
        graph[5].add(4);
        graph[6].add(7);
        graph[7].add(2);
        graph[7].add(6);
        graph[7].add(8);
        graph[8].add(1);
        graph[8].add(7);


        System.out.println("graph: " + Arrays.toString(graph));

        dfs(1); // 정점 1부터 탐색 시작
    }

}
