package study.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1473 {

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
                    // 가장 큰 범위를 구해야하기때문에
                    // 한 그래프에서 탐색범위가 여러개가 나오면 그 중 가장 큰 것을 고르기위해 Math.max 사용
                    int temp = sum;
                    sum = 0;
                    dfs(i, j);
                    sum = Math.max(temp, sum);
                }

            }
        }

        System.out.println(sum);
    }

    public static void dfs(int x, int y) {
        // 탐색횟수체크
        sum++;
        // 방문여부 체크
        isVisited[x][y] = true;

        // 상하좌우니까 4번
        for (int k = 0; k < 4; k++) {
            // 위치지정
            int xx = x + dx[k];
            int yy = y + dy[k];

            // 네방향을 벗어나는곳은 탐색안함
            if (xx < 0 || yy < 0 || xx >= n || yy >= m)
                continue;

            // 탐색
             if (!isVisited[xx][yy] && arr[xx][yy] == 1) {
                dfs(xx, yy);
            }
        }
    }


}
