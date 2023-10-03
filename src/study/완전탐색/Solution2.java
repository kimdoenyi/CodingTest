package study.완전탐색;

/**
 * 최소 필요 피로도, 소모 피로도
 * 재귀 .. dfs .. 백트래킹 ..
 */
class Solution2 {
    static boolean isVisited[];
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }

    public void dfs(int k, int[][] dungeons, int depth) {
        // 종료조건 , 탐색을 이미 했거나 최소 필요피로도보다 적게 남은 경우
        for(int i = 0; i < dungeons.length; i++) {
            if(isVisited[i] || dungeons[i][0] > k) {
                continue;
            }

            isVisited[i] = true;
            dfs(k - dungeons[i][1], dungeons, depth+1);
            isVisited[i] = false;
        }
        answer = Math.max(answer, depth);
    }
}
