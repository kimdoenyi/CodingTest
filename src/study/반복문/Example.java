package study.반복문;

import java.util.Arrays;

public class Example {

    public static void main(String[] args) {

        int[][] arr = new int[4][5];

        int num = 0;

        // 1. 행부터 읽는 기본 포문
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                if(num > 9) {
                    num = 0;
                }
                arr[i][j] = num;
                num++;
            }
        }
        print(arr);


        // 2. 열부터 읽는 포문
        num = 0;

        arr = new int[4][5];

        for(int i=0; i<5; i++) {
            for(int j=0; j<4; j++) {
                if(num > 9) {
                    num = 0;
                }
                arr[j][i] = num;
                num++;
            }
        }
        print(arr);

        // 3. 행 -> 열 , ㄹ 로 읽기
        arr = new int[4][5];
        num = 0;
        for(int i=0; i<4; i++) {
            if(i % 2 == 0) {
                for(int j=0; j<5; j++) {
                    arr[i][j] = num;
                    num++;
                }
            } else {
                for(int j=4; j>=0; j--) {
                    arr[i][j] = num;
                    num++;
                }
            }
        }
        print(arr);
    }

    static void print(int[][] arr) {
        System.out.println("배열을 출력합니다.");
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
