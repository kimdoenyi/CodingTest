package study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main1026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        String str = br.readLine();
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(str.split(" ")[i]);
        }

        Integer arr2[] = new Integer[n];
        str = br.readLine().trim();
        for(int i = 0 ; i < n; i++ ) {
            arr2[i] = Integer.parseInt(str.split(" ")[i]);
        }

        Arrays.sort(arr);
        Arrays.sort(arr2, Collections.reverseOrder());

        int sum = 0;
        for(int i = 0; i < n; i ++) {
            sum += arr[i] * arr2[i];
        }

        System.out.println(sum);
    }
}
