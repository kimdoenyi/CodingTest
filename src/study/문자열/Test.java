package study.문자열;

public class Test {
    public static void main(String[] args) {
        String s = "this Is don't touch Me";
        String ans = "";

        String[] arr = s.split(" ");


        for(String str : arr) {
            StringBuilder sb = new StringBuilder(str);
            if(!Character.isUpperCase(str.charAt(0))) {
                char a  = Character.toUpperCase(str.charAt(0));
                // 지정된 위치의 문자 교체
                //System.out.println(str);
                //System.out.println(a);
                sb.setCharAt(0, a);
                str = sb.toString();
            }
            ans += str+" ";
        }

        System.out.println(ans);
    }
}
