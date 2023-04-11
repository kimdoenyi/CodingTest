package study.완전탐색;

import java.io.*;
import java.util.*;

public class 배낭문제DP {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  //물건 개수
        int k = Integer.parseInt(st.nextToken());  //최대 무게

        int[] w = new int[n+1]; // 물건의 무게
        int[] v = new int[n+1]; // 물건의 가치

        // 표를 만듬
        int[][] dp = new int[n+1][k+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1 ; j <= k; j++) {
                if(w[j] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j-w[i]]+v[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

    }
}
