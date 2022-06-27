import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=1721 lang=java
 *
 * [1721] 交换链表中的节点
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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        // 找到 left 节点
        for (int i = 1; i < k; i++) {
            left = left.next;
        }
        ListNode cur = left;
        // 找到right节点
        while (cur.next != null) {
            right = right.next;
            cur = cur.next;
        }
        int m = right.val;
        right.val = left.val;
        left.val = m;
        return head;
    }
}
// @lc code=end
