package study.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2 2
 * 0 1
 * 1 0
 */
public class Main4963 {

    public static int arr[][];  // 지도
    public static boolean isVisited[][];  // 방문여부
    public static int N, M;
    public static int count = 0;

    static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dy = {1, -1, 0, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        while(true) {
            st = new StringTokenizer(br.readLine());

            // 종료조건
            if("0 0".equals(st)) {
                break;
            }

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // x,y 잘 생각해야함 !!
            arr = new int[M][N];
            isVisited = new boolean[M][N];

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 탐색시작
            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if(dfs(i,j)) {
                        count++;
                    }
                }
            }

            System.out.println(count);
            count = 0;

        }
    }

    static boolean dfs(int x, int y) {
        if(x == -1 || y == -1 || x == N || y == M) return false;

        if(arr[x][y] == 0) return false;

        arr[x][y] = 0;

        for (int i = 0; i < dx.length; i++) {
            int xx = dx[i];
            int yy = dy[i];
            dfs(x + xx, y + yy);
        }
        return true;
    }
}
