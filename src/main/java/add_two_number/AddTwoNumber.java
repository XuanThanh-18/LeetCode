package add_two_number;

import java.util.List;

public class AddTwoNumber {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
        public static ListNode addTwoNumber(ListNode l1, ListNode l2){
//            ListNode dumyHeard = new ListNode(0);
//            ListNode current = dumyHeard;
//            int carry = 0;
//            while(l1 != null || l2 != null){
//                int x = l1.val;
//                int y = l2.val;
//                int sum = x+y;
//                if(sum>=10) carry = 1;
//                current.next = new ListNode(sum%10);
//                current = current.next;
//                if(l1 != null ) l1 = l1.next;
//                if(l2 != null ) l2 = l2.next;
//            }
//            if(carry>0){
//                current.next = new ListNode(carry);
//            }
//            return dumyHeard.next;
            ListNode result = new ListNode(0);
            ListNode current = result;
            int carry=0;
            while(l1 != null || l2 != null){
                int sum = l1.val + l2.val + carry;
                carry = sum/10;
                current = new ListNode(sum%10);
                l1 = l1.next;
                l2 = l2.next;
            }
            if(carry > 0){
                current.next = new ListNode(carry);
            }
            return current;
        }
        public static void main(String[] args) {
            ListNode l1 = new ListNode();
            ListNode l2 = new ListNode();
            l1.val=2;
            l1.next=new ListNode(3,new ListNode(4));
            l2.val = 5;
            l2.next = new ListNode(6,new ListNode(7));
            ListNode result = addTwoNumber(l1,l2);
            System.out.println(result);
        }
    }

}
