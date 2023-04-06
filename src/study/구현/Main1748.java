package study.구현;

import java.util.Scanner;

public class Main1748 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력값
        int n = sc.nextInt();
        int count = 0;
        int num = 10;
        int plus = 1;

        for(int i=1; i<=n; i++) {
            // 자릿수 체크
            if(i % num == 0) {
                // 자릿수 증가
                num *= 10;
                plus++;
            }
            count += plus;
        }

        System.out.println(count);

    }
}
