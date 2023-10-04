package study.반복문;

public class TwoPointer {

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int n = sequence.length;
        int startIdx = 0;
        int endIdx = 0;
        int sum = 0;
        int temp = Integer.MAX_VALUE;

        while(endIdx != n) {
            if(sum == k) {
                // 그리고 이전 길이와 현재 길이를 비교해서 더 짧은거를 저장해야함
                int length = endIdx - startIdx;
                if(temp > length) {
                    temp = length;
                    // startIdx 랑 endIdx-1 을 저장해야함 ..!
                    answer[0] = startIdx;
                    answer[1] = endIdx-1;
                }
                sum -= sequence[startIdx];
                startIdx++;
            } else if(sum > k) {
                sum -= sequence[startIdx];
                startIdx++;
            } else {
                sum += sequence[endIdx];
                endIdx++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Sequence s = new Sequence();
        int[] num = {1, 1, 1, 2, 3, 4, 5};
        int[] answer = s.solution(num, 5);

        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]+" ");
        }
        // System.out.println();
    }
}
