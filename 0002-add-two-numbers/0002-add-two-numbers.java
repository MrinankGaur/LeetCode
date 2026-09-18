/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        int a = 0;
        int b = 0;
        int carry = 0;
        while(l1!=null || l2!=null){
            if(l1!=null){
                a = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                b = l2.val;
                l2 = l2.next;
            }
            int sum = a + b + carry;
            if(sum>9){
                carry = 1;
            }else{
                carry = 0;
            }
            ListNode node = new ListNode(sum%10);
            temp.next = node;
            temp = node;
            a=0;
            b=0;
        }
        if(carry==1){
            ListNode node = new ListNode(1);
            temp.next = node;
        }
        return head.next;
        
        
    }
}
