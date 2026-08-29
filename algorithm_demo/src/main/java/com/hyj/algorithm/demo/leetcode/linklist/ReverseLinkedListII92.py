from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


'''
 1 2 3 4 5 6
'''


class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if left == right:
            return head
        cur = head
        cnt = 1
        # find left right
        leftNode = None
        rightNode = None
        leftPre = None
        rightAfter = None
        pre = None
        while cur:
            nex = cur.next
            if left == cnt:
                leftNode = cur
                leftNode.next = None
                leftPre = pre
            if cnt > left:
                # part reverse
                cur.next = pre
            if right == cnt:
                rightNode = cur
                rightAfter = nex
                break
            pre = cur
            cur = nex
            cnt = cnt + 1
        if leftPre:
            leftPre.next = rightNode
        if leftNode:
            leftNode.next = rightAfter

        if left==1:
            # means include head, right is a new head
            return rightNode
        return head


def printout(node):
    while node:
        print(node.val)
        node = node.next
    print('----------------')


if __name__ == '__main__':
    head = ListNode(1, ListNode(2))
    sol = Solution()
    tmp=sol.reverseBetween(head, 1, 2)
    printout(tmp)
