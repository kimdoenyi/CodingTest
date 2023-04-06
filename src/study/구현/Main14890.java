package study.구현;

import java.util.*;
import java.io.*;

public class Main14890 {

    static int n,l;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        // 행 (왼->오 , 오->왼)
        // 열 (위->아래, 아래->위)
        for(int i=0; i<n; i++) {
            if(findRoadByRow(i)) {
                count++;
            }
            if(findRoadByCol(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean findRoadByCol(int col) {
        boolean[] isIncline = new boolean[n]; //경사면 설치 여부를 확인하는 배열

        // 조건에 부합하지않는것들 제거
        for(int i=0; i<n-1; i++) {
            int diff = arr[i][col] - arr[i+1][col];

            // 높이차는 -1, 0, 1 만 됨
            if(diff < -1 || diff > 1) {
                return false;
            } else if(diff == -1) {     // 뒤에가 더 큰 경우
                // 경사로 설치가능한지 체크
                for(int j = 0; j < l; j++) {
                    // 현재 인덱스가 앞이고 뒷 인덱스의 값이 더 크기때문에 - 연산
                    if(i - j < 0 || isIncline[i - j]) {
                        return false;
                    }
                    // 비교하려는 뒷 인덱스의 값 arr[row][i - j]
                    if(arr[i][col] != arr[i - j][col]) {
                        return false;
                    }
                    isIncline[i - j]  = true; //경사면 설치
                }
            } else if(diff == 1) {
                // 경사로 설치가능한지 체크
                for(int j = 1; j <= l; j++) {
                    // 현재 인덱스가 앞이고 뒷 인덱스의 값이 더 작기때문에 + 연산
                    if(i + j >= n || isIncline[i + j]) {
                        return false;
                    }
                    if(arr[i][col] - 1 != arr[i + j][col]) {
                        return false;
                    }
                    isIncline[i + j] = true;
                }
            }
        }
        return true;
    }

    private static boolean findRoadByRow(int row) {
        boolean[] isIncline = new boolean[n]; //경사면 설치 여부를 확인하는 배열

        // 조건에 부합하지않는것들 제거
        for(int i=0; i<n-1; i++) {
            int diff = arr[row][i] - arr[row][i+1];

            // 높이차는 -1, 0, 1 만 됨
            if(diff < -1 || diff > 1) {
                return false;
            } else if(diff == -1) {     // 뒤에가 더 큰 경우
                // 경사로 설치가능한지 체크
                for(int j = 0; j < l; j++) {
                    // 현재 인덱스가 앞이고 뒷 인덱스의 값이 더 크기때문에 - 연산
                    if(i - j < 0 || isIncline[i - j]) {
                        return false;
                    }
                    // 비교하려는 뒷 인덱스의 값 arr[row][i - j]
                    if(arr[row][i] != arr[row][i - j]) {
                        return false;
                    }
                    isIncline[i - j]  = true; //경사면 설치
                }
            } else if(diff == 1) {
                // 경사로 설치가능한지 체크
                for(int j = 1; j <= l; j++) {
                    // 현재 인덱스가 앞이고 뒷 인덱스의 값이 더 작기때문에 + 연산
                    if(i + j >= n || isIncline[i + j]) {
                        return false;
                    }
                    // 경사로를 놓을 L개의 칸이 높은칸과 차이가 1만큼 나야한다
                    if(arr[row][i] - 1 != arr[row][i + j]) {
                        return false;
                    }
                    isIncline[i + j] = true;
                }
            }
        }
        return true;
    }
}
