package study.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 반례
 * 3
 * ZCY
 * ZCP
 * PYZ
 */
public class Main3085 {
    // 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열) 길이 구하기
    static int maxLength(int inputArr[][]) {
        int max = 0;

        // 행에서 가장 큰 길이 구하기
        for(int i=0; i<inputArr.length; i++) {
            int count = 1;
            for(int j=1; j<inputArr[i].length; j++) {
                if(inputArr[i][j-1] == inputArr[i][j]) {
                    count++;
                } else {
                    count = 1;
                }
                max = max < count ? count : max;
            }
        }

        // 열에서 가장 큰 길이 구하기
        for(int i=0; i<inputArr.length; i++) {
            int count = 1;
            for(int j=1; j<inputArr[i].length; j++) {
                if(inputArr[j-1][i] == inputArr[j][i]) {
                    count++;
                } else {
                    count = 1;
                }
                max = max < count ? count : max;
            }
        }
        return max;
    }

    static void copyArray(int[][] target, int[][] copy) {
        for(int i=0; i<target.length; i++) {
            for(int j=0; j<target[i].length; j++) {
                copy[i][j] = target[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 배열 초기화
        int[][] arr = new int[n][n];
        // 배열 생성
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        // 배열 카피 -> 깊은 복사해야 원본값이 변경되도 변경 안됨
        int[][] copyArr = new int[n][n];
        copyArray(arr, copyArr);

        int max = maxLength(arr);

        // 행 swap
        for(int i=0; i<arr.length; i++) {
            int temp = 0;
            for(int j=1; j<arr[i].length; j++) {
                if(arr[i][j-1] != arr[i][j]) {
                    temp = arr[i][j-1];
                    arr[i][j-1] = arr[i][j];
                    arr[i][j] = temp;
                }
                int swapMax = maxLength(arr);
                if(max < swapMax) {
                    max = swapMax;
                }
                // 배열 원상복구
                copyArray(copyArr, arr);
            }
        }

        // 열 swap
        for(int i=0; i<arr.length; i++) {
            int temp = 0;
            for(int j=1; j<arr[i].length; j++) {
                if(arr[j-1][i] != arr[j][i]) {
                    temp = arr[j-1][i];
                    arr[j-1][i] = arr[j][i];
                    arr[j][i] = temp;
                }
                int swapMax = maxLength(arr);
                if(max < swapMax) {
                    max = swapMax;
                }
                // 배열 원상복구
                copyArray(copyArr, arr);
            }
        }

        System.out.println(max);
    }
}
