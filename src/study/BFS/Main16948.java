package study.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//(r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)
public class Main16948 {

    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    static int[][] arr;
    static boolean[][] isVisited;

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 칸의 갯수
        n = Integer.parseInt(br.readLine());
        // 배열 초기화
        arr = new int[n][n];
        isVisited = new boolean[n][n];

        String str = br.readLine();
        int nx = Integer.parseInt(str.split(" ")[0]);
        int ny = Integer.parseInt(str.split(" ")[1]);

        int mx = Integer.parseInt(str.split(" ")[2]);
        int my = Integer.parseInt(str.split(" ")[3]);

        Point2 point = new Point2(nx, ny, 0);
        isVisited[nx][ny] = true;

        System.out.println(bfs(mx, my, point));
    }

    static int bfs(int endX, int endY, Point2 point) {
        Queue<Point2> queue = new LinkedList<>();
        queue.add(point);

        while(!queue.isEmpty()) {
            Point2 p = queue.poll();

            if(p.getX() == endX && p.getY() == endY) {
                return p.getCnt();
            }

            for(int i=0; i<6; i++) {
                int px = p.getX() + dx[i];
                int py = p.getY() + dy[i];
                int cnt = p.getCnt();

                if(px >= 0 && px < n && py >= 0 && py < n && !isVisited[px][py]) {
                    queue.add(new Point2(px, py, cnt+1));
                    isVisited[px][py] = true;
                }
            }
        }

        return -1;
    }
}

class Point2 {
    int x, y, cnt;

    public Point2(int x, int y, int cnt) {
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
