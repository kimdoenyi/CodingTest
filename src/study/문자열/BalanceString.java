package study.문자열;

import java.util.Stack;

/**
 *
 * 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
 * 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
 * 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
 *   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
 * 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
 *   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
 *   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
 *   4-3. ')'를 다시 붙입니다.
 *   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
 *   4-5. 생성된 문자열을 반환합니다.
 *
 */
public class BalanceString {

    public String dfs(String p) {
        // String answer = "";

        if(p.length() == 0) {
            return p;
        }
        // "()))((()"
        // 2. 균형잡힌 문자열로 분리
        String u = "";
        String v = "";
        int lcnt = 0;
        int rcnt = 0;

        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') {
                lcnt++;
            } else {
                rcnt++;
            }

            u += p.charAt(i);

            if(lcnt == rcnt) {
                v = p.substring(i+1);
                break;
            }
        }

        //System.out.println("u = " + u);
        //System.out.println("v = " + v);

        // String newV = "";
        // 3. u 가 올바른 문자열인지 체크
        if(isCorrect(u)) {
            // 3-1 수행
            return u += dfs(v);
        } else {
            String newV = "(";
            newV += dfs(v);
            newV += ")";
            // u의 첫번째와 마지막문자 제거
            u = u.substring(1, u.length()-1);
            // 나머지 문자 괄호방향 뒤집기
            for(int i = 0; i < u.length(); i++) {
                if(u.charAt(i) == '(') {
                    newV += ')';
                } else {
                    newV += '(';
                }
            }

            return newV;
        }

    }

    public boolean isCorrect(String u) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < u.length() ; i++) {
            if(u.charAt(i) == '(') {
                stack.push(u.charAt(i));
            } else {
                if(stack.isEmpty() || stack.peek() == ')') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        BalanceString b = new BalanceString();
        System.out.println(b.dfs("()))((()"));
    }
}
