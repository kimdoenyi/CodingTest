package study.완전탐색;

public class NationOf124 {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};

        while(n > 0) {
            int remainder = n % 3;
            n /= 3;

            if(remainder == 0) {
                n--;
            }
            System.out.println("n : "+n);
            answer = numbers[remainder] + answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        NationOf124 n = new NationOf124();
        System.out.println(n.solution(18));
    }
}
