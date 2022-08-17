package study.DFS;

public class Test {

    public static void main(String[] args) {
        DFS(1);
    }

    static void DFS(int i) {

        if(i == 100) {
            return;
        }

        // 스택에 쌓아두는 구조를 보여줌
        System.out.println(i+"번째 호출입니다.");
        DFS(i+1);
        System.out.println(i+"번째 호출이 끝났습니다.");

    }
}
