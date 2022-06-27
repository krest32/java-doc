/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {
    class Node {
        int val;
        Node next, prev;

        public Node(int val) {
            this.val = val;
        }
    }

    class DoublyLinkedList {
        Node head = new Node(-1);
        Node tail = new Node(-1);
        int size;
        int capacity;

        public DoublyLinkedList(int capacity) {
            this.head.next = tail;
            this.tail.prev = head;
            this.size = 0;
            this.capacity = capacity;
        }

        public void insertAtTail(Node n) {
            Node prev = tail.prev;
            tail.prev = n;
            n.next = tail;
            prev.next = n;
            n.prev = prev;
            this.size++;
        }

        public void insertAtHead(Node n) {
            Node next = head.next;
            n.next = next;
            next.prev = n;
            n.prev = head;
            head.next = n;
            this.size++;
        }

        public void remove(Node n) {
            n.next.prev = n.prev;
            n.prev.next = n.next;
            this.size--;
        }

        public void removeAtTail() {
            remove(tail.prev);
        }

        public void removeAtHead() {
            remove(head.next);
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public boolean isFull() {
            return this.size == this.capacity;
        }

    }

    DoublyLinkedList dll;

    public MyCircularDeque(int k) {
        dll = new DoublyLinkedList(k);
    }

    public boolean insertFront(int value) {
        if (dll.size < dll.capacity) {
            Node n = new Node(value);
            dll.insertAtHead(n);
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (dll.size < dll.capacity) {
            Node n = new Node(value);
            dll.insertAtTail(n);
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (!dll.isEmpty()) {
            dll.removeAtHead();
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!dll.isEmpty()) {
            dll.removeAtTail();
            return true;
        }
        return false;
    }

    public int getFront() {
        if (dll.isEmpty()) {
            return -1;
        }
        return dll.head.next.val;
    }

    public int getRear() {
        if (dll.isEmpty()) {
            return -1;
        }
        return dll.tail.prev.val;
    }

    public boolean isEmpty() {
        return dll.isEmpty();
    }

    public boolean isFull() {
        return dll.isFull();
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end
