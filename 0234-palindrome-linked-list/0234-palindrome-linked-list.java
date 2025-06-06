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
    public boolean isPalindrome(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        ListNode headSecond = reverseList(s);
        while(headSecond!=null){
           if(head.val != headSecond.val){
               return false;
           }
           head = head.next;
           headSecond = headSecond.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head){
        if(head==null)return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}