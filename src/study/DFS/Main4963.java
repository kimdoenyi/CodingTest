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
    public static int count = 1;

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
                    if(!isVisited[i][j] && arr[i][j] == 1) {
                        count++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(count);
            count = 0;

        }
    }

    public static void dfs(int x, int y) {

        // 기저조건
        if(x <= -1 || x >= N || y <= -1 || y >= N) {
            return;
        }

        if(!isVisited[x][y] && arr[x][y] == 1) {
            isVisited[x][y] = true;

            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);
        }
    }
}
