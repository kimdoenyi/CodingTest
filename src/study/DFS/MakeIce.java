package study.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeIce {

    static int[][] list;
    static boolean[][] isVisited;
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        list = new int[m][n];
        isVisited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                // '0' 을 빼줘야 왜 ,, 숫자가 들어가지 ?
                list[i][j] = str.charAt(j) - '0';
            }
        }

        // dfs 호출
        int result = 0;

        // 모든 위치 한번씩 수행
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(dfs(i, j)) {     // 함수 호출 -> 수행
                    result += 1;
                }
            }
        }

        System.out.println(result);

    }

    static boolean dfs(int x, int y) {

        // 주어진 범위가 벗어나는 경우 체크
        if(x <= -1 || x >= m || y <= -1 || y >= n) {
            return false;
        }

        if(list[x][y] == 0) {
            list[x][y] = 1;

            // 상하좌우 방문
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);

            return true;
        }

        return false;
    }
}
