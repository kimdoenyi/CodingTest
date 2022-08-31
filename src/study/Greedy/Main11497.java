package study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11497 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());	// 테스트케이스 갯수

        while(tc != 0) {
            int n = Integer.parseInt(br.readLine());	// 통나무 갯수
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // 배열 생성
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 오름차순 정렬
            Arrays.sort(arr);

            int[] nums = new int[n];

            // 홀수번째 - 왼쪽 , 짝수번째 - 오른쪽으로 위치하여 정렬
            int left = 0;
            int right = n-1;

            for(int i=0; i<n; i++) {
                if(i % 2 == 0) {
                    nums[right--] = arr[i];
                } else {
                    nums[left++] = arr[i];
                }
            }

            int min = 0;
            // 인접한 배열의 크기 비교
            for (int i=1; i<n; i++) {
                min = Math.max(min, Math.abs(nums[i] - nums[i-1]));
            }
            // 처음과 끝 통나무도 크기비교
            min = Math.max(min, Math.abs(nums[0] - nums[n-1]));
            System.out.println(min + " ");
            tc -= 1;
        }
    }
}

