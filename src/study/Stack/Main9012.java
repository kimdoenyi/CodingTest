package study.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 괄호 , palindrome
 */
public class Main9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 갯수
        int size = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        while(size != 0) {
            String str = br.readLine();
            for(int i = 0; i < str.length(); i++) {
                if('(' == str.charAt(i)) {
                    stack.push(str.charAt(i));
                } else {
                    // 스택이 비어있는 경우에 ')' 가 들어올 경우를 체크해야함
                    if(stack.isEmpty()) {
                        stack.push(str.charAt(i));
                        break;
                    } else {
                        stack.pop();
                    }
                }

            }

            if(stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            stack.clear();
            size--;
        }

    }
}
