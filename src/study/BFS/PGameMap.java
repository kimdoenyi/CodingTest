package study.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Game {
    static boolean isVisited[][];

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public int bfs(int[][] maps, int startX, int startY, int endX, int endY) {
        Queue<Pos> node = new LinkedList<>();
        node.add(new Pos(startX, startY, 1));
        isVisited[startX][startY] = true;

        while(!node.isEmpty()) {
            Pos p = node.poll();
            // 현재 좌표
            int x = p.x;
            int y = p.y;
            int level = p.level;

            for(int i = 0; i < 4; i++) {
                // 움직일 좌표
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= endX || ny < 0 || ny >= endY) {
                    continue;
                }

                if(nx == endX-1 && ny == endY-1){
                    return level;
                }

                if(maps[nx][ny] == 1 && !isVisited[nx][ny]) {
                    node.offer(new Pos(nx, ny, level+1));
                    isVisited[nx][ny] = true;
                }
            }
        }

        return -1;
    }

    public int solution(int[][] maps) {
        int answer = 0;

        isVisited = new boolean[maps.length][maps[0].length];
        answer = bfs(maps, 0, 0, maps.length, maps[0].length);

        return answer;
    }

}
public class PGameMap {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(new Game().solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
    }
}
