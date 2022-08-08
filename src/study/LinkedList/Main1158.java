package study.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            list.add(i);
        }

        // 인덱스
        int idx = 0;
        System.out.print("<");
        while(!list.isEmpty()) {

            idx += k-1;
            while (idx >list.size()-1) { // list 사이즈를 넘어가면 처리
                idx = idx - list.size();
            }

            System.out.print(list.get(idx));
            list.remove(idx);
            if (!list.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }


}
