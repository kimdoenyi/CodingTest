package study.LinkedList;

/**
 * 단방향 LinkedList 구현하기
 */
public class Node {

    int data;
    Node next = null;

    public Node(int d) {
        this.data = d;
    }

    // this 는 참조변수로 인스턴스 자신을 가리킨다
    // 삽입
    public void append(int d) {
        Node end = new Node(d);
        Node n = this;

        while(this.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    // 삭제
    public void delete(int d) {
        Node n = this;

        while(n.next != null) {
            if(n.next.data == d) {
                // 다음 노드로 연결
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }
}
