package study.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for(int j=0; j<=cnt; j++) {
            String[] strs = br.readLine().split(" ");

            int m = Integer.parseInt(strs[0]);
            int n = Integer.parseInt(strs[1]);
            int x = Integer.parseInt(strs[2])-1;
            int y = Integer.parseInt(strs[3])-1;

            boolean flag = false;

            for(int i=x; i<m*n; i+=m) {
                if(i%n == y) {
                    System.out.println(i+1);
                    cnt--;
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                System.out.println("-1");
            }

            if(cnt == 1) {
                return;
            }
        }
    }
}
