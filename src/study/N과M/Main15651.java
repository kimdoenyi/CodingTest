package study.N과M;

import java.io.*;
import java.util.StringTokenizer;

public class Main15651 {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] isVisited;

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 4 2
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 결과를 담을 배열 : 뽑을 갯수만큼 만들기
        arr = new int[M];
        // 방문여부 체크
        isVisited = new boolean[N];

        dfs(0);

        System.out.print(sb);
    }

    public static void dfs(int depth) {

        // 종료조건
        if(depth == M) {
            // 2개씩 다 뽑은 경우 출력
            for(int val : arr) {
                sb.append(val + " ");
            }
            sb.append('\n');
            return;
        }

        // 탐색
        for(int i=0; i<N; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                arr[depth] = i+1;		// 현재 depth 인덱스에 값을 저장한다
                isVisited[i] = false;	// 탐색이 종료되면 방문여부 초기화
                dfs(depth+1);			// depth를 증가하여 한번 더 탐색
            }
        }
    }

}

