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
       ListNode mid = getMid(head);
       ListNode newhead = mid.next;
       mid.next = null;
       ListNode head2 = reverse(newhead);
       ListNode temp = head;
       
       while(temp!=null && head2!=null){
            ListNode tempNext = temp.next;   
            ListNode head2Next = head2.next;
            temp.next = head2;              
            head2.next = tempNext;          
            temp = tempNext;               
            head2 = head2Next;
        }
    }
    
    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next= prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}