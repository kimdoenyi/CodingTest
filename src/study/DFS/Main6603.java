package study.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 순열 문제
 */
public class Main6603 {

    static boolean[] isVisited;
    static int[] list;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        // 7 1 2 3 4 5 6 7
        while(true) {
            String[] splitStr = br.readLine().split(" ");
            N = Integer.parseInt(splitStr[0]);
            if(N == 0) {
                break;
            }

            // 노드의 갯수
            int size = Integer.parseInt(splitStr[0]);

            list = new int[size];
            isVisited = new boolean[size];

            for(int i=0; i<size; i++) {
                list[i] = Integer.parseInt(splitStr[i+1]);
            }
            Dfs(0, 0);
            System.out.println();
        }
    }

    static void Dfs(int data, int depth) {

        if(depth == 6) {
            for(int i=0; i<N; i++) {
                if(isVisited[i]){
                    System.out.print(list[i]+" ");
                }
            }
            System.out.println();
        }

        for(int i=data; i<N; i++) {
            isVisited[i] = true;
            Dfs(data+1, depth+1);
            isVisited[i] = false;
        }
    }
}
