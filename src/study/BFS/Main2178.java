package study.BFS;

import java.io.*;
import java.util.*;

public class Main2178 {

    static int[][] list;
    static int n,m;

    // 상하좌우
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static int bfs(int x, int y) {
        // 큐 구현 -> 탐색할 노드를 담을 큐
        Queue<Node> q = new LinkedList<>();
        // 현재 노드를 큐에 담는다
        q.offer(new Node(x,y));

        // 큐가 빌때까지 탐색
        while(!q.isEmpty()) {
            // 현재 큐에 들어있는 값 가져오기
            Node node = q.poll();
            // 현재 노드의 좌표값
            x = node.getX();
            y = node.getY();

            // 현재 위치에서 상하좌우로 이동 ..
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 종료조건
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                // 0 이면 이동불가
                if(list[nx][ny] == 0) {
                    continue;
                }

                // 1(이동가능) 이고, 처음 방문이면 최단거리 기록
                if(list[nx][ny] == 1) {
                    list[nx][ny] = list[x][y] + 1;
                    q.offer(new Node(nx,ny));
                }

            }
        }

        return list[n-1][m-1];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");

        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);

        list = new int[n][m];

        // 배열 생성
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                list[i][j] = str.charAt(j)-'0';
            }
        }

        System.out.println(bfs(0, 0));

    }

}
