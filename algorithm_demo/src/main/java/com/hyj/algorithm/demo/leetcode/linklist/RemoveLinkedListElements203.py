from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


'''
 6
 1,2,6,3,4,5,6
 1 2 3 4 5
'''


class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        pre = dummy
        cur = head
        while cur:
            nex = cur.next
            if val == cur.val:
                pre.next = nex
            else:
                pre = cur
            cur = cur.next
        return dummy.next


def printout(node):
    while node:
        print(node.val)
        node = node.next
    print('----------------')


if __name__ == '__main__':
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(2, ListNode(5)))))
    sol = Solution()
    tmp = sol.removeElements(head, 2)
    printout(tmp)
