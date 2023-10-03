package study.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 노드를 만들어줌
class Pos {
    int x;
    int y;
    int level;

    public Pos(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}

class Solution2 {
    // 좌표
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // 맵을 담을 배열
    static char[][] map;
    // 방문여부체크
    static boolean[][] isVisited;

    // bfs 탐색
    public int bfs(int startX, int startY, int h, int w, int endX, int endY) {
        Queue<Pos> pos = new LinkedList<>();
        // 첫번째 노드 생성
        pos.add(new Pos(startX, startY, 0));
        // 방문여부 체크
        isVisited[startX][startY] = true;

        // 탐색
        while(!pos.isEmpty()) {
            Pos now = pos.poll();
            int x = now.x;
            int y = now.y;
            int level = now.level;

            // 종료조건체크
            if(x == endX && y == endY) {
                return level;
            }

            // 상하좌우 확인
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    continue;
                }

                if(map[nx][ny] != 'X' && !isVisited[nx][ny]) {
                    pos.offer(new Pos(nx, ny, level+1));
                    isVisited[nx][ny] = true;
                }
            }
        }
        // 시작점에서 통과할 수 있는 문이 없으면 -1
        return -1;
    }

    public int solution(String[] maps) {
        int answer = 0;

        map = new char[maps.length][maps[0].length()];
        isVisited = new boolean[maps.length][maps[0].length()];

        Pos startPos = null;
        Pos endPos = null;
        Pos leverPos = null;

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(maps[i].charAt(j) == 'S') {
                    startPos = new Pos(i, j, 0);
                }

                if(maps[i].charAt(j) == 'L') {
                    leverPos = new Pos(i, j, 0);
                }

                if(maps[i].charAt(j) == 'E') {
                    endPos = new Pos(i, j, 0);
                }

                map[i][j] = maps[i].charAt(j);
            }
        }

        // 시작점 -> 레버까지 한번 돌리기
        answer = bfs(startPos.x, startPos.y, maps.length, maps[0].length(), leverPos.x, leverPos.y);
        // 실패경로가 아니라면 한번 더 돌려서 레버에서 마지막문까지 돌려야함 ?
        if(answer > -1) {
            // 방문여부 초기화
            isVisited = new boolean[maps.length][maps[0].length()];
            int temp = bfs(leverPos.x, leverPos.y, maps.length, maps[0].length(), endPos.x, endPos.y);

            if(temp == -1) {
                answer = -1;
            } else {
                answer += temp;
            }

        }
        return answer;
    }
}

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(new Solution2().solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
        // System.out.println(new Solution2().solution(new String[]{"EOOOO","XXXXX ","LOOSO","XXXXX","OOOOX"}));
    }
}
