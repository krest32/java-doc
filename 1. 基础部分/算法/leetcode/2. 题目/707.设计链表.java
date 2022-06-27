/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start
class MyLinkedList {

    // 定义变量 链表长度、头结点
    int size;
    ListNode head;

    // 初始化变量
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    // 获取某个节点
    public int get(int index) {
        // 判断index是否无效
        if (index < 0 || index >= size)
            return -1;
        ListNode curr = head;
        // 迭代链表
        for (int i = 0; i < index + 1; ++i)
            curr = curr.next;
        return curr.val;
    }

    // 追加头节点
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    // 追加尾节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 向固定索引位置追加节点
    public void addAtIndex(int index, int val) {
        // 判断 index 是否无效
        if (index > size)
            return;

        // 参数小于0，以0进行对待
        if (index < 0)
            index = 0;

        ++size;
        // 迭代列表到指定位置
        ListNode pred = head;
        for (int i = 0; i < index; ++i)
            pred = pred.next;
        // 初始化新节点
        ListNode toAdd = new ListNode(val);
        // 插入新的节点
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    // 删除某个位置的node
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;

        size--;

        ListNode pred = head;
        for (int i = 0; i < index; i++)
            pred = pred.next;
        // 删除节点
        pred.next = pred.next.next;
    }
}

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end
