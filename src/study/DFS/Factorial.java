package study.DFS;

public class Factorial {

    static int sum = 1;

    public static void main(String[] args) {
        System.out.println(factorial(4));
        // System.out.println(sum);
    }

    static int factorial(int num) {
        // 종료조건 주의 !!
        if(num <= 1) {
            return 1;
        }

        // sum *= num;
        return num * factorial(num-1);

    }
}
