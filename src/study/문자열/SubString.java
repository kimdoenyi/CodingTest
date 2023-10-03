package study.문자열;

public class SubString {

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        if(s.length() == 1) {
            return 1;
        }

        for(int i = 1; i <= s.length()/2; i++) {
            StringBuilder sb = new StringBuilder();
            String prevStr = "";
            int count = 1;

            // 문자열 압축
            for(int j = 0; j <= s.length()-i; j += i) {
                String curStr = s.substring(j, j+i);

                System.out.print(curStr + " / ");
                // System.out.println(count);
                // 문자열 연속여부 체크
                if(prevStr.equals(curStr)) {
                    count++;
                    continue;
                } else if(count > 1){
                    sb.append(count + prevStr);
                    count = 1;
                } else {
                    sb.append(prevStr);
                }
                prevStr = curStr;
            }
            // 압축되지않은 부분 붙이기
            sb.append(count > 1 ? count+prevStr : prevStr);

            if(s.length() % i != 0) {
                sb.append(s.substring(s.length() - s.length() % i, s.length()));
            }

            System.out.println(" = "+sb.toString());

            answer = Math.min(sb.length(), answer);
            sb = new StringBuilder();
        }

        return answer;
    }

    public static void main(String[] args) {
        SubString s = new SubString();
        System.out.println(s.solution("aabbaccc"));
    }
}
