package study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1969 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // DNA 수
        int m = Integer.parseInt(st.nextToken()); // 문자열의 길이

        String[][] arr = new String[n][m];

        // 배열에 값 생성
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = str.split("")[j];
            }
        }
        Map.Entry<String, Integer> maxEntry ;
        String key = "";
        int value = 0;

        for(int i=0; i<m; i++) {
            Map<String, Integer> map = new HashMap<>();
            for(int j=0; j<n; j++) {
                map.put(arr[j][i], map.getOrDefault(arr[j][i], 0)+1);
            }
            // 맵에 들어있는 값중에 가장 큰값의 키를 가져오기
            maxEntry = map.entrySet().stream()
                    .max(Comparator.comparing(Map.Entry::getValue))
                    .orElse(null);
            key += maxEntry.getKey();
            // 최소값 = 전체 - 최대값
            value += n-maxEntry.getValue();
        }

        System.out.println(key);
        System.out.println(value);

    }
}
