package study.완전탐색;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String numbers = "12345";

        List<Character> list = new ArrayList<>();

        char[] arr = numbers.toCharArray();

        for(int i = 0 ; i < arr.length; i++) {
            list.add(arr[i]);
        }

    }
}
