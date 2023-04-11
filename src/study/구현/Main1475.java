package study.구현;

import java.util.Scanner;

public class Main1475 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String room = sc.next();
        int[] check = new int[10];

        for(int i = 0; i < room.length(); i++) {
            int num = room.charAt(i) - '0';
            // 6 인 경우 9에 값 증가
            if(num == 6) {
                check[9]++;
            } else {
                check[num]++;
            }
        }
        
        int nine = check[9]/2;
        if (check[9] % 2 == 1) nine++;
        check[9] = nine;
        
        int max = 0;

        for(int i = 0; i < check.length; i++) {
            max = Math.max(max, check[i]);
        }

        max = Math.max(max,nine);

        System.out.print(max);

    }
}
