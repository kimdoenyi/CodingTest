package study.Stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();
        String reverseStr = "";

        while(size-- > 0) {
            String str = br.readLine()+"\n";

            for(char ch : str.toCharArray()) {
                if(ch == ' ' || ch == '\n') {
                    // pop
                    while(!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    // 공백
                    bw.write(ch);
                } else {
                    // push
                    stack.push(ch);
                }
            }

            bw.flush();

        }




    }
}
