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
        if(head == null || head.next == null){
            return;
        }

        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null; 

        ListNode head2 = reverse(next);
        merge(head,head2);

    }

    private static void merge(ListNode head1, ListNode head2){
        //int flag = 0;
        while(head1 != null && head2 != null){
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            
            head1.next = head2;
            head1 = next1;
            if(next1 != null){
                head2.next = next1;
                head2 = next2;
            }
            
        }
        
    }

    private static ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverse(next);

        
        next.next = head;
        head.next = null;
        return newHead;
    }

    private static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}