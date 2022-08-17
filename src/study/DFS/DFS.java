package study.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFS {

    // 인접리스트 만들기
    // 방문여부 배열을 만든다
    // 스택에 삽입할때 방문여부 = true, 스택에서 뺄때 출력
    static ArrayList<Integer>[] list;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        // 인덱스와 값을 맞추기위해 node+1
        isVisited = new boolean[node+1];
        list = new ArrayList[node+1];

        // 인접리스트 초기화
        for(int i=1; i<node+1; i++) {
            list[i] = new ArrayList<>();
        }

        // 인접리스트에 관계 생성
        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            // 양방향 인접그래프 생성
            list[n1].add(n2);
            list[n2].add(n1);
        }

        int count = 0;

        for(int i=1; i<node+1; i++) {
            if(!isVisited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    static void dfs(int v) {

        if(isVisited[v]) {
            return;
        }
        // 스택에 삽입한경우와 동일
        isVisited[v] = true;

        for(int i : list[v]) {
            if(!isVisited[i]) {
                dfs(i);
            }
        }
    }

}
