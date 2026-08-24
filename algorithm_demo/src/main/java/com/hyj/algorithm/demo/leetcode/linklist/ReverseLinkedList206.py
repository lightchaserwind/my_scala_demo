from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


'''
d 1 2 3
'''


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        pre = head
        cur = head.next
        pre.next = None
        while cur:
            next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        return pre


def printout(node):
    while node:
        print(node.val)
        node = node.next
    print('----------------')


if __name__ == '__main__':
    head = ListNode(1, ListNode(2, ListNode(3)))
    sol = Solution()

    head = sol.reverseList(head)
    printout(head)
