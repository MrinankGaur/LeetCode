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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==1){
            return lists[0];
        }
        ListNode head = null;
        for(int i = 0;i<lists.length;i++){

            head = merge(head,lists[i]);
        }
        return head;

    }
    public ListNode merge(ListNode head1, ListNode head2){
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }

        ListNode temp = new ListNode();
        ListNode tail = temp;
        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next= head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if(head1!=null){
            tail.next=head1;
        }
        if(head2!=null){
            tail.next=head2;
        }
        return temp.next;
    }
}