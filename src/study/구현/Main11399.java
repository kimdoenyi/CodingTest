package study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        String str = br.readLine();
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(str.split(" ")[i]);
        }
        // 오름차순 정렬
        Arrays.sort(arr);

        int sum = arr[0];

        for(int i=1; i<n; i++) {
            int temp = arr[i] + arr[i-1];
            sum += temp;
            arr[i] = temp;
        }

        System.out.println(sum);
    }
}
