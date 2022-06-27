/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 通过迭代的方法对于链表进行排序
     * 
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        // 对于链表进行判空
        if (head == null) {
            return head;
        }
        // 定义哑元节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        // 开始遍历当前节点
        while (curr != null) {
            // 如果上一个排序好的元素小于当前节点，则继续下一个操作
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                // 进行排序
                ListNode prev = dummyHead;
                // 找到前一个小于当前的节点
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                // 进行位置交换
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            // 迭代下一个节点
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
// @lc code=end
