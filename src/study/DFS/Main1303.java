package study.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1303 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] arr;
    static boolean[][] isVisited;

    static int n, m, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        n = Integer.parseInt(str.split(" ")[0]);
        m = Integer.parseInt(str.split(" ")[1]);

        arr = new char[n+1][m+1];
        isVisited = new boolean[n+1][m+1];

        // 배열 생성
        for(int i=0; i<n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 'W' && !isVisited[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    result = cnt * cnt;
                }
            }
        }

        System.out.println(result);
    }

    static void dfs(int x, int y) {

        isVisited[x][y] = true;
        cnt += 1;

        for(int i=0; i<4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if(mx < 0 || mx >= n || my < 0 || my >= m) {
                continue;
            }

            if(arr[mx][my] == 'W' && !isVisited[mx][my]) {
                dfs(mx, my);
                isVisited[mx][my] = true;
            }
        }
    }
}
