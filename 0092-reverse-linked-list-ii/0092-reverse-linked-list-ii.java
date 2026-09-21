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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for(int i =  0;i<left-1;i++){
            prev = prev.next;
        }

        ListNode head1 = prev.next;
        
        ListNode tail1 = prev.next;

        
        for(int i = 0;i<right-left;i++){
            tail1=tail1.next;
        }
        ListNode nextNode = tail1.next;

        prev.next = null;
        tail1.next = null;

        ListNode curr = head1;
        ListNode p = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = p;
            p = curr;
            curr = next;
        }
        prev.next = tail1;
        head1.next = nextNode;

        return dummy.next;
    }
}