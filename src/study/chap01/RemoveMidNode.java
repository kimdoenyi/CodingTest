package study.chap01;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 단방향 LinkedList 에서 중간노드 삭제하기
 */
public class RemoveMidNode {

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
        removeMidNode(linkedList,3);
        retrieveList(linkedList);
    }

    public static void retrieveList(LinkedList linkedList) {
        Iterator<Integer> iter = linkedList.iterator();

        while(iter.hasNext()) {
            System.out.print(iter.next());
            if(iter.hasNext()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void removeMidNode(LinkedList linkedList, int node) {
        linkedList.remove(node-1);
    }
}
