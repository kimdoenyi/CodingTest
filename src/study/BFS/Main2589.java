package study.BFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 육지(L) 만 가야하며 최단경로를 구해야함 -> BFS
 * 한칸당 1시간 - 상하좌우로만 이동가능
 *
 * 탐색할때마다 최소시간을 갱신
 */
public class Main2589 {

    static char[][] arr;
    static boolean[][] isVisited;

    static int n,m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];

        // 배열 생성방법 ..!
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int min = 0;

        // 탐색 시작
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 'L') {
                    // 방문여부체크를 .. 탐색할때마다 새로해줘야함 ..?
                    isVisited = new boolean[n][m];
                    min = Math.max(bfs(i,j), min);
                }
            }
        }

        System.out.println(min);
    }

    static int bfs(int x, int y) {
        Queue<Node2> queue = new LinkedList<>();
        int result = 0;

        // 입력된 좌표의 노드 생성 -> 초기화니까 카운트는 0
        Node2 node = new Node2(x,y,0);

        // 첫번째 노드 삽입
        queue.add(node);
        // 해당 위치 방문체크
        isVisited[x][y] = true;

        // 큐가 비어있지않을때까지 탐색
        while(!queue.isEmpty()) {
            // 큐에 첫번째로 들어간거 뺌
            Node2 qu = queue.poll();

            for(int i=0; i<4; i++){
                // 큐에서 꺼낸 위치의 상하좌우 인접좌표 탐색
                int xx = dx[i] + qu.getX();
                int yy = dy[i] + qu.getY();

                if(xx < 0 || xx >= n || yy < 0 || yy >= m ){
                    continue;
                }

                if(!isVisited[xx][yy] && arr[xx][yy] == 'L') {
                    // 한번 더 방문체크
                    isVisited[xx][yy] = true;
                    // 큐에 꺼낸값의 인접노드 추가 , cnt 증가
                    queue.add(new Node2(xx, yy, qu.cnt+1));
                    // 애는 대체 뭘까 ..?
                    result = Math.max(result, qu.cnt+1);
                }
            }
        }

        return result;
    }
}

class Node2 {
    int x;
    int y;
    int cnt;

    public Node2(int x, int y, int cnt) {
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
}
