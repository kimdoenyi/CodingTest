package study.LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
 * 왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
 * 오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
 */
public class Main1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<>();

        int n = sc.nextInt();   // 큐의 크기
        int m = sc.nextInt();   // 뽑아내려는 수의 갯수
        int count = 0; // 2번 , 3번 연산 누적합

        // 리스트에 크기만큼 값을 삽입한다.
        for(int i = 1; i <= n; i++) {
            list.offer(i);
        }

        // 뽑으려는 수의 갯수를 배열에 담는다
        int[] arr = new int[m];
        for(int i = 0 ; i < m ; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < m ; i++) {
            // 뽑고자하는 값의 인덱스 찾기
            int dequeIdx = list.indexOf(arr[i]);
            int halfIdx ;

            // 리스트 사이즈가 짝수면 중간지점은 size/2-1
            if(list.size() % 2 == 0) {
                halfIdx = list.size() / 2 - 1;
            } else {
                halfIdx = list.size() / 2;
            }

            // 리스트 인덱스가 halfIdx 보다 작으면 2번 수행
            if(dequeIdx <= halfIdx) {
                // 맨앞에 있는 값 가져와서 뒤에 붙이기
                for(int j=0; j<dequeIdx; j++) {
                    int temp = list.pollFirst();
                    list.offerLast(temp);
                    count++;
                }
            } else {
                // 리스트 인덱스가 halfIdx 보다 크면 3번 수행 , 마지막 값을 가져와서 앞에 붙이기
                for(int j=0; j<list.size() - dequeIdx; j++) {
                    int temp = list.pollLast();
                    list.offerFirst(temp);
                    count++;
                }
            }
            // 1번 수행 , 첫번째 원소 삭제
            list.pollFirst();
        }

        System.out.println(count);
    }
}
