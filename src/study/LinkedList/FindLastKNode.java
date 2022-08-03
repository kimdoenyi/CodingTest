package study.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 끝에서 K번째 노드를 찾는 알고리즘
 *
 * 방법 1) 전체 노드의 갯수 = N 일때 , N-K+1 의 위치 구하기
 * 방법 2) 재귀함수사용 ,, 모르겠음
 * 방법 3) 포인터 전략 사용
 */
public class FindLastKNode {

    public static void main(String[] args) {
        // 리스트 선언
        LinkedList<Integer> linkedList = new LinkedList<>();

        // 리스트 값 삽입
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(9);
        linkedList.add(6);
        linkedList.add(1);
        linkedList.add(10);
        linkedList.add(3);

        retrieveList(linkedList);
        findLastNode1(linkedList, 2);
        findLastNode3(linkedList, 2);
    }
    public static void retrieveList(LinkedList linkedList) {
        Iterator<Integer> iter = linkedList.iterator();

        while(iter.hasNext()) {
            System.out.print(iter.next()) ;
            if(iter.hasNext()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void findLastNode1(LinkedList linkedList, int k) {
        // 리스트의 전체 노드 갯수 구하기 = N
        // N-K+1 위치의 값 구하기 , 인덱스는 0 부터 시작이라는 점 주의 !!
        System.out.println(linkedList.get(linkedList.size()-k));

    }

    public static void findLastNode3(LinkedList linkedList, int k) {
        // 포인터 두개를 이용하여 첫번째 포인터의 시작 위치는 k , 두번째 포인터는 0에서 시작
        // 하나씩 이동하면서 첫번째 포인터가 마지막까지 도착했을때 두번째 포인터의 위치를 리턴
        int p1 = k;
        int p2 = 0;

        while(p1 != linkedList.size()) {
            p2++;
            p1++;
        }

        System.out.println(linkedList.get(p2));
    }
}
