package study.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2606 {

    static int n, m;
    static int map[][]; // 정점 간 탐색 경로 저장
    static boolean isVisited[];   // 방문여부
    static int count;       // 바이러스 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터 수 (정점)
        n = Integer.parseInt(br.readLine());
        // 연결된 컴퓨터 쌍의 수 (간선)
        m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        isVisited = new boolean[n+1];

        StringTokenizer st;

        // 인접행렬 만들기
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방향이니까 ..
            map[a][b] = map[b][a] = 1;
        }

        System.out.println(bfs(1));

    }

    static int bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        isVisited[x] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            // 정점이 1부터 시작하니까 1부터 탐색해야함
            for(int i=1; i<=n; i++) {
                if(map[temp][i] == 1 && !isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
