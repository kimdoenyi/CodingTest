package study.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Digit 합산 알고리즘
 */
public class DigitSumList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        LinkedList<Integer> linkedList2 = new LinkedList<>();

        linkedList1.add(9);
        linkedList1.add(1);
        linkedList1.add(4);

        linkedList2.add(6);
        linkedList2.add(4);
        linkedList2.add(3);
        linkedList2.add(2);
        
        Iterator<Integer> iter1 = linkedList1.iterator();
        Iterator<Integer> iter2 = linkedList2.iterator();

        LinkedList<Integer> linkedList3 = new LinkedList<>();

        int value = 0;
        int carry = 0;

        while(iter1.hasNext() && iter2.hasNext()) {

           value = iter1.next() + iter2.next() + carry;

           if(value >= 10) {
               carry = value / 10;
               value %= 10;
           } else {
               carry = 0;
           }

            linkedList3.add(value);
        }

        if(carry != 0) {
            linkedList3.add(carry);
        }

        for (int a : linkedList3 ) {
            System.out.println("a = " + a);
        }
    }

}
