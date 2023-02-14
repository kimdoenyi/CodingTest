package study.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2644 {

    static int n, m, answer;
    static int map[][] ;    // 탐색 그래프
    static boolean isVisited[]; // 방문 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정점의 수
        n = Integer.parseInt(br.readLine());
        // 구해야 할 관계
        String str = br.readLine();
        int parent = Integer.parseInt(str.split(" ")[0]);
        int child = Integer.parseInt(str.split(" ")[1]);

        // 간선의 수
        m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        isVisited = new boolean[n+1];

        // 인접행렬 생성하는 방법 꼭 알아두자 !!
        StringTokenizer st;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        dfs(parent, child, 0);

        if(answer == 0) {
            answer = -1;
        }

        System.out.println(answer);

    }

    static void dfs(int x, int y, int cnt) {
        // 방문체크
        isVisited[x] = true;

        // 기저조건
        if(x == y) {
            answer = cnt;
            return;
        }

        // 탐색은 늘 정점만큼 하자 !
        for(int i=1; i<=n; i++) {
            if(map[x][i] == 1 && !isVisited[i]) {
                isVisited[i] = true;
                // 방문체크를 x 기준으로 하고 있으니까 x 값이 바뀌는게 맞지
                dfs(i, y, cnt+1);
            }
        }

    }
}
