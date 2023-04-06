package study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2563 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        // 배열을 만든다
        int arr[][] = new int[100][100];

        for(int i=0; i<size; i++) {
            String str = br.readLine();
            int x = Integer.parseInt(str.split(" ")[0]);
            int y = Integer.parseInt(str.split(" ")[1]);

            // 입력받은 범위만큼 탐색하면서 그 위치를 1로 바꾼다
            for(int k=x; k<x+10; k++) {
                for(int l=y; l<y+10; l++) {
                    arr[k][l] = 1;
                }
            }
        }

        // 1의 갯수를 센다
        int result = 0;
        for(int[] temp : arr) {
            for(int cnt : temp) {
                if(cnt == 1) {
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
