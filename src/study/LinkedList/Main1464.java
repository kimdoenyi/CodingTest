package study.LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class Main1464 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        LinkedList<Character> strList = new LinkedList<>();

        for(int i=0; i<str.length(); i++) {
            strList.offer(str.charAt(i));
        }

        for(int i=0; i<strList.size(); i++) {
            for(int j=i; j<strList.size()-1; j++) {
                if(strList.get(i) > strList.get(j)) {
                    
                }
            }
         }
    }
}
