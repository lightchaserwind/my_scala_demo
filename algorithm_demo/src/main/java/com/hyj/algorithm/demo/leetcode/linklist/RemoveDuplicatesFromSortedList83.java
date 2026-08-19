package com.hyj.algorithm.demo.leetcode.linklist;

public class RemoveDuplicatesFromSortedList83 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy.next;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                // drop next
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        RemoveDuplicatesFromSortedList83 sol = new RemoveDuplicatesFromSortedList83();
        sol.print(head);
        sol.print(sol.deleteDuplicates(head));
    }
}
