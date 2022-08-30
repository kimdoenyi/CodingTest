package study.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1012 {

    static int[][] list;
    static int n,m;

    static boolean dfs(int x, int y) {

        if(x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }

        if(list[x][y] == 1) {
            list[x][y] = 0;

            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);

            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());	// 테스트케이스 갯수

        ArrayList<Integer> resultList = new ArrayList<>();

        while(testCase != 0) {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());	// 가로
            m = Integer.parseInt(st.nextToken());	// 세로
            int k = Integer.parseInt(st.nextToken());	// 배추가 심어진 위치의 갯수

            list = new int[n][m];

            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x][y] = 1;
            }

            int result = 0;

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(dfs(i,j)) {
                        result += 1;
                    }
                }
            }

            resultList.add(result);
            testCase--;
        }


        for(Integer i : resultList) {
            System.out.println(i);
        }

    }

}
