package study.Stack;

import java.util.Stack;

public class Correct {

    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        if(stack.isEmpty()) {
            answer = true;
        }

        return answer;
    }

    public static void main(String[] args) {
        Correct c = new Correct();
        System.out.println(c.solution(""));
    }
}
