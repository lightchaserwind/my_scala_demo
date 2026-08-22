package com.hyj.algorithm.demo.leetcode.linklist;

public class RemoveDuplicatesFromSortedList82 {
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
        ListNode prev = dummy;
        ListNode cur = dummy.next;
        Integer repeat = null;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                // set repeat
                repeat = cur.val;
            } else {
                if (repeat != null) {
                    // drop repeat
                    prev.next = cur.next;
                    // reset repeat
                    repeat = null;
                }else {
                    prev = prev.next;
                }
            }
            cur = cur.next;
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
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        RemoveDuplicatesFromSortedList82 sol = new RemoveDuplicatesFromSortedList82();
        sol.print(sol.deleteDuplicates(head));
    }
}
