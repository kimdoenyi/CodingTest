package study.구현;

import java.io.*;
import java.util.StringTokenizer;

public class Main13900 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 갯수
        int n = Integer.parseInt(br.readLine());
        String [] arr = br.readLine().split(" ");

        long sum = 0;
        for(int i=0; i<n; i++) {
            long tempSum = 0;
            for(int j=i+1; j<n; j++) {
                tempSum += Long.parseLong(arr[j]);
            }
            sum += Long.parseLong(arr[i]) * tempSum;
        }

        System.out.println(sum);
    }
}
