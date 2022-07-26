package study.chap01;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *  정렬되어있지않은 LinkedList 에 중복값 제거하기
 */
public class RemoveLinkedList {
    public static void main(String[] args) {

        // 링크드 리스트 선언
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(8);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(1);

        // retrieveList(linkedList);
        removeDuplicate(linkedList);
        retrieveList(linkedList);
    }

    public static void retrieveList(LinkedList linkedList) {
        Iterator<Integer> iter = linkedList.iterator();

        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

    }

    public static void removeDuplicate(LinkedList list) {

        Iterator<Integer> iter = list.iterator(); //Iterator 선언

        int n = 0;      // 현재 위치를 찍어주는 인덱스
        while(iter.hasNext() && n != list.size()){      // 다음값이 있는지 체크
            int r = n+1;  // 하나씩 돌아갈 인덱스
            while(r != list.size()) {
                // 연결된 노드에 다음값과 같으면 삭제
                if(list.get(n) == list.get(r)) {
                    list.remove(r);
                } else {
                    r++;
                }
            }
            n++;
        }

    }
}


