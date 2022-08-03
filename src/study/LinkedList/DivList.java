package study.LinkedList;

import java.util.Collections;
import java.util.LinkedList;

/**
 * LinkedList 에 있는 노드들을 X 값을 기준으로 작은 수는 왼쪽 , 큰수는 오른쪽에 배열하기
 * 단 X 는 왼쪽 오른쪽 어디든 상관없다
 */
public class DivList {

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

        // 람다식 내림차순정렬
        Collections.sort(linkedList, (x, y) ->  y - x);
        // 람다식 오름차순정렬
        Collections.sort(linkedList, (i, j) -> i - j);
        
        for(Integer i : linkedList) {
            System.out.println(i);
        }
    }

}
