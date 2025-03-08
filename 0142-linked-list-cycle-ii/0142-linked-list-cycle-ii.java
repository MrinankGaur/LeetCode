public class Solution{
    public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
       ListNode fast = head;
       int length=0;
       while(fast!=null && fast.next!=null){
             fast = fast.next.next;
             slow = slow.next;
             if(fast==slow){
                ListNode s = slow;
                do{
                    s=s.next;
                    length++;
                }while(s!=slow);
                break;
             }
       }
       if(length==0){
        return null;
       }
       ListNode s = head;
       ListNode f = head;
       while(length>0){
        s = s.next;
        length--;
       }
       while(f!=s){
        s=s.next;
        f=f.next;
       }

     return s;
    }
}