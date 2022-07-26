package study.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main1303 {

    static char[][] list;
    // 방문여부 체크
    static boolean[][] isVisited;

    static int n,m;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int count;

    static int bfs(int x, int y, char color) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        count = 1;
        isVisited[x][y] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();

            x = node.getX();
            y = node.getY();

            for(int i=0; i<4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if(!isVisited[nx][ny] && list[nx][ny] == color) {
                    q.offer(new Node(nx, ny));
                    isVisited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new char[n][m];
        isVisited = new boolean[n][m];

        // 배열 생성
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                list[i][j] = str.charAt(j);
            }
        }

        int rw = 0;
        int rb = 0;

        // 탐색 실행
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // count = 1;

                if(!isVisited[i][j]) {
                    // 아군인경우 탐색
                    if(list[i][j] == 'W') {
                        int num = bfs(i, j, 'W');
                        rw += (num * num);
                    }

                    // 적군인 경우 탐색
                    if(list[i][j] == 'B') {
                        int num = bfs(i, j, 'B');
                        rb += (num * num);
                    }
                }
            }
        }

        System.out.print(rw+" "+rb);
    }
}
