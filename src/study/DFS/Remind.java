package study.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Remind {
    static ArrayList<Integer>[] list;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());    // 정점의 갯수 : 4
        int line = Integer.parseInt(st.nextToken());    // 간선의 갯수 : 5
        int startNode = Integer.parseInt(st.nextToken()); // 시작점 : 1

        // 인접리스트 생성
        list = new ArrayList[node+1];

        // 인접리스트 각각 노드 초기화
        for(int i=1; i<=node; i++) {
            list[i] = new ArrayList<Integer>();
        }

        // 인접리스트 생성
        for(int i=0; i<line; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 양방향
            list[x].add(y);
            list[y].add(x);
        }

        // 정렬
        for(int i=1; i<=node; i++) {
            Collections.sort(list[i]);
        }

        // DFS 방문 체크 배열 생성
        isVisited = new boolean[node+1];
        DFS(startNode);
        System.out.println("");

    }

    static void DFS(int idx) {
        // 탐색시작(어차피 스택에 노드가 한번 들어오면 빠지는 일만 남음)
        System.out.print(idx);
        System.out.print(" ");

        if(isVisited[idx]) {
            return;
        }
        // 방문체크
        isVisited[idx] = true;

        // 탐색
        for(int i : list[idx]) {
            DFS(i);
        }
    }


}
