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
    static int[] arr = new int[1000000];
    public void reorderList(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while(temp!=null){
            arr[n++]=temp.val;
            temp=temp.next;
        }
        ListNode x = head;
        int i = 1;
        int j = n-1;
        for(int k = 1;k<n;k++){
            if(k%2==0){
                ListNode y = new ListNode(arr[i++]);
                x.next = y;
                x = x.next;
            }
            else{
                ListNode y = new ListNode(arr[j--]);
                x.next = y;
                x = x.next;
            }
        }
    }
}