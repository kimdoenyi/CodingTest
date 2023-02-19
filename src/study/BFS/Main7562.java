package study.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main7562 {

    static int arr[][];
    // 나이트가 이동 가능한 위치표시
    static int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};

    static boolean isVisited[][];

    static int l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 갯수
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++) {
            // 판의 크키
            l = Integer.parseInt(br.readLine());
            // 배열 초기화
            arr = new int[l][l];
            isVisited = new boolean[l][l];

            String str = br.readLine();
            // 현재 위치
            int nx = Integer.parseInt(str.split(" ")[0]);
            int ny = Integer.parseInt(str.split(" ")[1]);

            // 이동하려는 위치
            str = br.readLine();
            int mx = Integer.parseInt(str.split(" ")[0]);
            int my = Integer.parseInt(str.split(" ")[1]);

            // 좌표생성
            Point p = new Point(nx, ny, 0);
            // 최초 위치 탐색여부 체크
            isVisited[nx][ny] = true;
            // 탐색시작
            bfs(mx, my, p);

        }

    }

    /**
     *
     * @param i : 최종 위치 X 좌표
     * @param j : 최종 위치 Y 좌표
     * @param point : 초기화한 좌표위치
     */
    static void bfs(int i, int j, Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);

        while (!queue.isEmpty()) {
            Point node = queue.poll();
            // 도착점까지 도달하면 종료
            if(node.getX() == i && node.getY() == j) {
                System.out.println(node.cnt);
                break;
            }

            // 이동 가능 좌표가 8개임
            for(int a=0; a<8; a++) {
                int xx = node.getX() + dx[a];
                int yy = node.getY() + dy[a];
                int cnt = node.getCnt();

                if(xx >= 0 && xx < l && yy >= 0 && yy < l && !isVisited[xx][yy]) {
                    queue.add(new Point(xx, yy, cnt+1));
                    isVisited[xx][yy] = true;
                }
            }

        }

    }
}

class Point {
    int x, y, cnt;

    public Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCnt() {
        return cnt;
    }
}
