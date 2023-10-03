package study.스케줄링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());	// 시작시간
            arr[i][1] = Integer.parseInt(st.nextToken());	// 종료시간
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
        });

        int answer = 0;
        int end = 0;

        for(int i = 0; i < n ; i++) {
            if(end <= arr[i][0]) {
                answer++;
                end = arr[i][1];
            }
        }

        System.out.println(answer);
    }
}
