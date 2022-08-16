package study.DFS;

import java.util.LinkedList;
import java.util.Stack;

public class DfsTest {

    class Graph{
        class Node {
            int data;
            LinkedList<Node> adjacent;  // 인접한 관계를 나타내는것 , 자식관계
            boolean marked;         // 방문여부

            public Node(int data) {
                this.data = data;
                this.marked = false;
                adjacent = new LinkedList<>();  // 링크드리스트를 준비시킨다
            }
        }

        Node[] nodes;   // 노드들을 저장할 배열

        // 노드들을 배열에 저장할 공간을 만듬
        public Graph(int size) {
            nodes = new Node[size];

            // 배열에 노드를 생성함
            for(int i=0; i<size; i++) {
                nodes[i] = new Node(i);
            }
        }

        // 두 노드의 관계를 저장하는 함수
        void addEdge(int i1, int i2) {
            Node n1 = new Node(i1);
            Node n2 = new Node(i2);

            // 관계 만들어주기
            if(!n1.adjacent.contains(n2)) {
                n1.adjacent.add(n2);
            }

            if(!n2.adjacent.contains(n1)) {
                n2.adjacent.add(n1);
            }
        }
        void dfs() {
            dfs(0);
        }

        void dfs(int index) {
            Node root = nodes[index];
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            root.marked = true;

            while(!stack.isEmpty()) {
                Node r = stack.pop();

                for(Node n : r.adjacent) {
                    if(!n.marked) {
                        n.marked = true;
                        stack.push(n);
                    }
                }
                visit(r);
            }
        }

        void visit(Node node) {
            System.out.print(node + " ");
        }
    }
}
