package study.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이렇게 풀면 메모리 초과가 난다 ..!
 */
public class Main1473_2 {

    // 탐색그래프
    static int[][] arr;
    // 방문여부 체크
    static boolean[][] isVisited;

    static int n, m, k, sum;

    // 상하좌우 좌표설정
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받은값
        String input = br.readLine();

        n = Integer.parseInt(input.split(" ")[0]);
        m = Integer.parseInt(input.split(" ")[1]);
        k = Integer.parseInt(input.split(" ")[2]);

        // 배열 초기화
        arr = new int[n][m];
        isVisited = new boolean[n][m];

        // 그래프 생성
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 인덱스는 0부터 시작이니까요 ..
            arr[x - 1][y - 1] = 1;
        }

        // 탐색시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!isVisited[i][j] && arr[i][j] == 1) {
                    sum += dfs(i, j);
                }

            }
        }

        System.out.println(sum);
    }

    public static int dfs(int x, int y) {

        if(x < 0 || x > n || y < 0 || y > m) {
            return 0;
        }

        if(isVisited[x][y] && arr[x][y] == 1) {
            return 0;
        }
        // 방문여부 체크
        isVisited[x][y] = true;

        dfs(x-1, y);
        dfs(x, y-1);
        dfs(x+1, y);
        dfs(x, y+1);

        return 1;
    }


}
