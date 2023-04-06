package study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14891 {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[5][8];

        for(int i = 1; i <= 4; i++) {
            String s = br.readLine();
            for(int j = 0; j < 8; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        // 회전횟수
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            // 회전할 톱니바퀴 번호
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            // 각 톱니바퀴의 회전방향 구하기
            //0: 회전X, 1: 시계 방향, -1: 반시계 방향
            int[] directions = getRotateWheel(num, dir);

            for (int j = 1; j <= 4; j++) {
                if(directions[j] != 0) {
                    //i번째 바퀴를 회전시킨다.
                    rotate(arr[j], directions[j]);
                }
            }


        }

        System.out.println(getScore(arr));
    }

    /**
     * 톱니바퀴의 점수 합을 구한다.
     */
    private static int getScore(int[][] wheels) {
        int answer = 0;
        int score = 1;

        for (int i = 1; i <= 4; i++) {
            if (wheels[i][0] == 1) {
                answer += score;
            }

            score *= 2;
        }
        return answer;
    }

    private static int[] getRotateWheel(int num, int dir) {
        //0: 회전X, 1: 시계 방향, -1: 반시계 방향
        int[] directions = new int[5];
        directions[num] = dir;

        //회전 시킬 바퀴를 기준으로 왼쪽 바퀴들의 회전 여부와 방향을 구한다.
        for (int j = num; j > 1; j--) {
            //맞닿은 극이 같은 경우 다음 바퀴는 회전하지 않기 때문에
            //나머지 바퀴들의 회전방향도 구하지 않아도 된다.
            if (arr[j][6] == arr[j-1][2]) {
                break;
            }
            directions[j-1] = directions[j] * -1;
        }

        //회전 시킬 바퀴를 기준으로 오른쪽 바퀴들의 회전 여부와 방향을 구한다.
        for (int j = num; j < 4; j++) {
            //맞닿은 극이 같은 경우 다음 바퀴는 회전하지 않기 때문에
            //나머지 바퀴들의 회전방향도 구하지 않아도 된다.
            if (arr[j][2] == arr[j+1][6]) {
                break;
            }
            directions[j+1] = directions[j] * -1;
        }

        return directions;
    }

    private static void rotate(int[] wheel, int dir) {
        if (dir == 1) {
            int temp = wheel[7];

            for (int i = 7; i > 0; i--) {
                wheel[i] = wheel[i-1];
            }

            wheel[0] = temp;
        } else if (dir == -1) {
            int temp = wheel[0];

            for (int i = 0; i < 7; i++) {
                wheel[i] = wheel[i+1];
            }

            wheel[7] = temp;
        }
    }
}
