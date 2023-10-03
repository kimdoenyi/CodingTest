package study.완전탐색;

import java.util.Stack;

/**
 * 프로그래머스 뒤에 있는 큰 수 찾기
 * 완탐으로 하면 시간초과나서 스택써야함 ..
 */
public class 완전탐색을스택으로 {
    // 완전탐색 (재귀) 로 그 다음 큰 수 찾기
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            answer[i] = search(numbers[i], numbers, i);
        }

        return answer;
    }

    public int search(int x, int[] numbers, int idx) {
        for(int i = idx; i < numbers.length; i++) {
            if(x < numbers[i]) {
                return numbers[i];
            }
        }
        return -1;
    }

    // 스택
    public int[] solution1(int[] numbers) {
        int[] answer = new int[numbers.length];
        // 스택은 인덱스 관리
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < numbers.length; i++) {

            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
