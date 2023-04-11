package study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main15501 {

    static int n;
    static int min, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        // 원래 수열
        String str = br.readLine();

        String result = br.readLine();
        arr = new int[n];

        int idxA = 0;
        int idxB = 0;

        for(int i = 0 ; i < n; i ++) {
            arr[i] = Integer.parseInt(result.split(" ")[i]);
            if(arr[i] == 1) {
                idxA = i;
            }
            if(arr[i] == 3) {
                idxB = i;
            }
        }

        // 1 인덱스 양옆 값 확인 => 2,5
        checkIdx(idxA);
        if(checkVal(1)) {
            // 3 인덱스 양옆 값 확인 => 2, 4
            checkIdx(idxB);
            if(checkVal(3)) {
                System.out.println("good puzzle");
            } else {
                System.out.println("bad puzzle");
            }
        }
    }

    private static boolean checkVal(int num) {
        if(num == 1) {
            if((arr[min] == 2 || arr[max] == 2) && (arr[min] == 5 || arr[max] == 5)) {
                return true;
            }
        }

        if(num == 3) {
            if((arr[min] == 2 || arr[max] == 2) && (arr[min] == 4 || arr[max] == 4)) {
                return true;
            }
        }
        return false;
    }

    private static void checkIdx(int idx) {
        if(idx == 0) {
            min = n-1;
            max = 1;
        } else if(idx == n-1) {
            min = idx-1;
            max = 1;
        } else {
            min = idx-1;
            max = idx+1;
        }
    }
}
