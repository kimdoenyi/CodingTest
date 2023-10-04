package study.반복문;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [1, 1, 1, 2, 3, 4, 5]에서 합이 5인 연속된 부분 수열은 [1, 1, 1, 2], [2, 3], [5]가 있습니다.
 * 이 중 [5]의 길이가 제일 짧으므로 해당 수열의 시작 인덱스와 마지막 인덱스를 담은 [6, 6]을 반환합니다.
 */
public class Sequence {

    public int[] solution (int[] sequence, int k) {
        int[] answer = new int[2];
        ArrayList<Integer> idxList = new ArrayList<>();
        int length = Integer.MAX_VALUE;

        for(int i = 0; i < sequence.length; i++) {
            int sum = 0;
            int temp = 0;
            // System.out.println("i = " + i);

            ArrayList<Integer> list = new ArrayList<>();

            for(int j = i; j <= sequence.length; j++) {
                // System.out.println("j = "+j);
                //System.out.println("sum = " + sum);
                if(sum == k) {
                    // i 부터 j-1 까지가 범위인데 이걸 어캐 가져감 ?
                    temp = list.size();

                    if(temp < length) {
                        length = temp;
                        idxList = new ArrayList<>();

                        for(Integer a : list) {
                            // System.out.println(a);
                            idxList.add(a);
                        }
                    }
                    break;
                } else if(sum > k || (sum < k && j == sequence.length)) {
                    continue;
                }
                // System.out.println("j2 = "+j);
                sum += sequence[j];
                list.add(j);
            }

        }

        if(idxList.size() == 1) {
            answer[0] = idxList.get(0);
            answer[1] = answer[0];
        } else {
            answer[0] = idxList.get(0);
            answer[1] = idxList.get(idxList.size()-1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Sequence s = new Sequence();
        int[] num = {1, 2, 3, 4, 5};
        int[] answer = s.solution(num, 7);

        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]+" ");
        }
        System.out.println();
    }
}
