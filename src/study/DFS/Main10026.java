package study.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10026 {

    // 정상인 배열
    static char[][] arr;
    // 적록색맹 배열
    static char[][] rgArr;

    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        // 입력갯수
        n = Integer.parseInt(br.readLine());

        // 배열 초기화 .. n+1 인 이유 ..?
        arr = new char[n+1][n+1];
        rgArr = new char[n+1][n+1];
        isVisited = new boolean[n+1][n+1];

        // 배열 생성
        for(int i=0; i<n; i++) {
            str = br.readLine();
            for(int j=0; j<n; j++) {
                char alpha = str.charAt(j);
                arr[i][j] = alpha;
                // 적록색맹 배열 생성
                if(alpha == 'R') {
                    alpha = 'G';
                }
                rgArr[i][j] = alpha;
            }
        }

        int sum = 0;
        // 일반인 탐색
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int stepSize = 0;
                if(!isVisited[i][j]) {
                    dfs(i, j, arr);
                    stepSize++;
                }
                sum += stepSize;
            }
        }
        sb.append(sum);
        sb.append(" ");

        // 탐색여부 초기화
        isVisited = new boolean[n+1][n+1];
        // sum 변수 초기화
        sum = 0;
        // 적록색맹 탐색
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int stepSize = 0;
                if(!isVisited[i][j]) {
                    dfs(i, j, rgArr);
                    stepSize++;
                }
                sum += stepSize;
            }
        }

        sb.append(sum);
        System.out.println(sb.toString());
    }

    static void dfs(int x, int y, char[][] test) {
        // 방문여부체크
        isVisited[x][y] = true;

        for(int i=0; i<4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            // 상하좌우 범위를 벗어나는 경우
            if(xx < 0 || xx > n || yy < 0 || yy > n) {
                continue;
            }

            // 같은 색상인경우만 탐색
            if(!isVisited[xx][yy] && test[x][y] == test[xx][yy]) {
                dfs(xx, yy, test);
            }
        }
    }
}

