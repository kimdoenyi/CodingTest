package study.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1535 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람의 수
        int n = Integer.parseInt(br.readLine());
        // 잃는 체력
        String str = br.readLine();
        int[] lostHp = new int[n];
        for(int i = 0 ; i < n ; i++) {
            lostHp[i] = Integer.parseInt(str.split(" ")[i]);
        }
        // 얻는 기쁨
        str = br.readLine();
        int[] getHp = new int[n];
        for(int i = 0 ; i < n ; i++) {
            getHp[i] = Integer.parseInt(str.split(" ")[i]);
        }

        // 체력
        int min = 100;
        // 기쁨
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(min > 0 && min > lostHp[i]) {
                min -= lostHp[i];
                max += getHp[i];
            } else {
                break;
            }
        }

        System.out.println(max);

    }
}
