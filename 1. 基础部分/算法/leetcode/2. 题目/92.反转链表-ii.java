import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 迭代
        // return extracted(head, left, right);

        return test(head, left, right);
    }

    private ListNode test(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode leftHead = dummy;
        for (int i = 1; i < left; i++) {
            leftHead = leftHead.next;
        }
        ListNode cur = leftHead.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = leftHead.next;
            leftHead.next = next;
        }
        return dummy.next;
    }

    private ListNode extracted(ListNode head, int left, int right) {
        ListNode pre = new ListNode(-1, head);
        ListNode leftNode = pre;
        // 先找到反转列表的开始的前一个节点
        for (int i = 1; i < left; i++) {
            leftNode = leftNode.next;
        }

        // 找到需要反转的开始节点进行操作
        ListNode cur = leftNode.next;
        // 开始反转列表

        for (int i = 0; i < right - left; i++) {
            // 找到下一个的节点;
            ListNode next = cur.next;
            // 将next节点分离开始，同时将cur.next指向next的下一个节点
            cur.next = next.next;
            // 将next的下一个next重新指向了left节点
            next.next = leftNode.next;
            // 将leftnode 的节点向下一个节点进行推移
            leftNode.next = next;
        }
        return pre.next;
    }
}
// @lc code=end
