package com.hyj.algorithm.demo.leetcode.linklist;

import java.util.ArrayList;
import java.util.List;

public class DesignLinkedList707aa {
    // doubly linked list
    static class MyLinkedList {
        private class Node {
            private int val;
            private Node prev;
            private Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        public MyLinkedList() {

        }

        public int get(int index) {
            Node cur = getNode(index);
            return cur == null ? -1 : cur.val;
        }

        private Node getNode(int index) {
            if (index >= size) {
                return null;
            }
            Node cur;
            int mid = size / 2;
            if (index <= mid) {
                // find from head
                int c = 0;
                cur = head;
                while (c < index) {
                    cur = cur.next;
                    c++;
                }
            } else {
                // find from tail
                int c = size - 1;
                cur = tail;
                while (c > index) {
                    cur = cur.prev;
                    c--;
                }
            }
            return cur;
        }

        public void addAtHead(int val) {
            if (head == null) {
                head = new Node(val);
                tail = head;
            } else {
                Node node = new Node(val);
                node.next = head;
                head.prev = node;
                head = node;
            }
            size++;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            if (head == null) {
                head = node;
                tail = head;
            } else {
                Node tmp = tail;
                node.prev = tmp;
                tmp.next = node;
                tail = node;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            if (index == 0) {
                addAtHead(val);
                return;
            }
            Node cur = getNode(index);
            insert(cur, new Node(val));
        }

        private void insert(Node cur, Node node) {
            Node pre = cur.prev;
            node.prev = pre;
            pre.next = node;
            node.next = cur;
            cur.prev = node;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            Node cur = getNode(index);
            Node pre = cur.prev;
            Node nex = cur.next;

            // 更新头节点
            if (pre == null) {
                head = nex;
            } else {
                pre.next = nex;
            }

            // 更新尾节点
            if (nex == null) {
                tail = pre;
            } else {
                nex.prev = pre;
            }

            size--;
        }

        public void print() {
            Node cur = head;
            List<Integer> list = new ArrayList<>();
            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
            System.out.println(list);
        }
    }

    // singly linked list
    static class MySinglyLinkedList {
        private class Node {
            private int val;
            private Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        private Node dummyHead;
        private int size;

        public MySinglyLinkedList() {
            // avoid null check
            dummyHead = new Node(0);
        }

        public int get(int index) {
            Node cur = getNode(index);
            return cur == dummyHead ? -1 : cur.val;
        }

        private Node getNode(int index) {
            if (index >= size || index < 0) {
                return dummyHead;
            }
            // find from head
            Node cur = dummyHead.next;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur;
        }

        public void addAtHead(int val) {
            insertAfter(dummyHead, new Node(val));
            size++;
        }

        private void insertAfter(Node cur, Node node) {
            node.next = cur.next;
            cur.next = node;
        }


        public void addAtTail(int val) {
            Node node = new Node(val);
            insertAfter(getNode(size - 1), node);
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            if (index == 0) {
                addAtHead(val);
                return;
            }
            Node pre = getNode(index - 1);
            Node node = new Node(val);
            insertAfter(pre, node);
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            Node pre = getNode(index - 1);
            Node cur = pre.next;
            pre.next = cur.next;
            cur.next = null;
            size--;
        }

        public void print() {
            Node cur = dummyHead.next;
            List<Integer> list = new ArrayList<>();
            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        MySinglyLinkedList myLinkedList = new MySinglyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.deleteAtIndex(0);
        myLinkedList.addAtTail(2);
        System.out.println(myLinkedList.get(0));
        myLinkedList.print();
    }
}