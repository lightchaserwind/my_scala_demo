from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


'''
 1 2 3 4 5 6 7
 3 2 1 4 5 6 7
 3 2 1 6 5 4 7
'''


class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k == 1:
            return head
        # visit k nodes and reverse
        newHead = head
        lastTurnEndNode = None
        leftNode = head
        cur = head
        cnt = 1
        while cur:
            nex = cur.next
            if cnt % k == 0:
                # reverse k nodes from leftNode to cur
                tmp = leftNode
                tmpPre = None
                while tmp:
                    tmpnex = tmp.next
                    tmp.next = tmpPre
                    if tmp == cur:
                        break
                    tmpPre = tmp
                    tmp = tmpnex

                if lastTurnEndNode:
                    lastTurnEndNode.next = cur
                if cnt == k:
                    newHead = cur
                leftNode.next=nex
                # reset
                lastTurnEndNode = leftNode
                leftNode = nex
            cur = nex
            cnt = cnt + 1
        return newHead

    def reverseKGroup2(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k == 1:
            return head
        # get len of nodes
        # get turns of k
        # reverse until every k
        # visit k nodes and reverse
        newHead = head
        lastTurnEndNode = None
        leftNode = head
        cur = head
        cnt = 1
        while cur:
            nex = cur.next
            if cnt == k:
                # reverse k nodes from leftNode to cur
                tmp = leftNode
                tmpPre = None
                while tmp:
                    tmpnex = tmp.next
                    tmp.next = tmpPre
                    if tmp == cur:
                        break
                    tmpPre = tmp
                    tmp = tmpnex
            cur = nex
            cnt = cnt + 1
        return head


def printout(node):
    while node:
        print(node.val)
        node = node.next
    print('----------------')


if __name__ == '__main__':
    head = ListNode(1, ListNode(2,ListNode(3,ListNode(4,ListNode(5)))))
    sol = Solution()
    tmp = sol.reverseKGroup(head, 2)
    printout(tmp)
