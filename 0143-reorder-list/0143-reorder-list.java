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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // finding mid point
        ListNode mid = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            mid = mid.next;
            fast = fast.next.next;
        }
        //breadking list into 2 lists at the midpoint
        ListNode second = mid.next;
        mid.next = null;
        
        //reversing second list;
        ListNode prev = null;
        while(second!=null){
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        //merging the two lists

        second = prev;
        ListNode first = head;

        while (second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;

            first.next = second;
            second.next = next1;

            first = next1;
            second = next2;
        }

    }
}
