# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return True
        
        slow,fast = head,head
        while fast and fast.next:
            slow,fast = slow.next,fast.next.next 
        prev,curr = None,slow
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        while prev:
            if(head.val!=prev.val):
                return False
            head = head.next
            prev = prev.next
        return True