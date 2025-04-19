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
    static int[] arr = new int[100000];
    public void reorderList(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while(temp!=null){
            arr[n++]=temp.val;
            temp = temp.next;
        }
        ListNode x = head;
        int j = 1;
        int k = n-1;
        for(int i = 1;i<n;i++){
            if(i%2!=0){
                ListNode y = new ListNode(arr[k]);
                x.next = y;
                x = x.next;
                k--;
            }
            else{
                ListNode y = new ListNode(arr[j]);
                x.next = y;
                x=x.next;
                j++;
            }
        }
    }
}