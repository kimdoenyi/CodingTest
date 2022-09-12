package study.BruteForce;

import java.util.Scanner;

/**
 * ㅋㅏ잉 달력
 */
public class Main1476 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();

        int year = 0;
        int E = 0;
        int S = 0;
        int M = 0;

        while(true) {
            E++;
            S++;
            M++;
            year++;

            if(E == 16) {
                E = 1;
            }

            if(S == 29) {
                S = 1;
            }

            if(M == 20) {
                M = 1;
            }

            if(E == e && S == s && M == m) {
                break;
            }
        }

        System.out.println(year);
    }
}
