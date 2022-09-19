package study.N과M;

import java.util.Scanner;

public class Main15649 {

    public static int[] arr;
    public static boolean[] visit;

    static int N;
    static int M;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        // 결과를 담을 배열 -> M 뽑을 갯수만큼 ,,
        arr = new int[M];
        // 방문여부를 체크하는 배열 -> N 전체 갯수만큼 ,,
        visit = new boolean[N];
        dfs(0);

    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

}