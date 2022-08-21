package study.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 너비우선탐색 , 큐 사용
 * 방문 여부 체크
 */
public class BfsExample {

    static boolean[] isVisited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        // 현재 노드를 저장
        q.offer(start);
        // 현재 노드 방문처리
        isVisited[start] = true;
        // 큐가 비어있을때까지 반복
        while(!q.isEmpty()) {
            // 큐에서 하나의 원소 뽑아서 출력
            int x = q.poll();
            System.out.print(x+ " ");
            // 해당 원소와 연결된 아직 방문하지않은 노드들 큐에 삽입
            for(int i=0; i<graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);

                if(!isVisited[y]) {
                    q.offer(y);
                    isVisited[y] = true;
                }
            }
        }

    }
    public static void main(String[] args) {
        graph.add(new ArrayList<>(Arrays.asList(2,3,8)));
        graph.add(new ArrayList<>(Arrays.asList(1,7)));
        graph.add(new ArrayList<>(Arrays.asList(1,4,5)));
        graph.add(new ArrayList<>(Arrays.asList(3,5)));
        graph.add(new ArrayList<>(Arrays.asList(3,4)));
        graph.add(new ArrayList<>(Arrays.asList(7)));
        graph.add(new ArrayList<>(Arrays.asList(2,6,8)));
        graph.add(new ArrayList<>(Arrays.asList(1,7)));

        isVisited = new boolean[9];

        bfs(0);

    }
}
