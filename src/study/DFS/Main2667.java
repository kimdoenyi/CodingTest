package study.DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main2667 {

    static int N;
    static int[][] list;
    static int homeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        list = new int[N][N];

        for(int i=0; i<N; i++) {
            String str = br.readLine();  // "0110100"
            for(int j=0; j<N; j++) {
                // char -> int '0' : 48 ,, 0 : 0
                list[i][j] = str.charAt(j)-'0';
            }
        }

        int aptCount = 0;
        ArrayList<Integer> homeList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                homeCount = 0;
                if(dfs(i, j)){
                    aptCount += 1;
                    homeList.add(homeCount);
                }
            }
        }

        System.out.println(aptCount);

        Collections.sort(homeList);

        for(int i : homeList) {
            System.out.print(i);

            if(!homeList.isEmpty()) {
                System.out.println();
            }
        }
    }

    static boolean dfs(int x, int y) {
        // 기저조건
        if(x <= -1 || x >= N || y <= -1 || y >= N) {
            return false;
        }

        // 실행부분
        if(list[x][y] == 1) {
            list[x][y] = 0;
            homeCount += 1;

            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);

            return true;
        }

        return false;
    }
}
