# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next or k==0:
            return head
        temp = head
        length = 1
        while temp.next:
            length+=1
            temp=temp.next
        temp.next = head
        k = length-(k%length)
        x = head
        for i in range(k-1):
            x = x.next
        head = x.next
        x.next = None
        
        return head