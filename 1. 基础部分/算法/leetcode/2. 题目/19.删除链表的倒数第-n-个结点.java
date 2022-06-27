import java.util.List;
import java.util.Stack;

import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 迭代 --> 最优解
        // return extracted(head, n);

        // 使用栈
        // return extracted2(head, n);

        // 1
        return test(head, n);
    }

    private ListNode test(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        ListNode cur = dummy;
        while (head != null) {
            head = head.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    /**
     * Your runtime beats 5.72 % of java submissions
     * Your memory usage beats 31.76 % of java submissions (39.5 MB)
     * 
     * @param head
     * @param n
     * @return
     */
    private ListNode extracted2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

    /**
     * 
     * 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了50.75%的用户
     * 
     * @param head
     * @param n
     * @return
     */
    private ListNode extracted(ListNode head, int n) {
        // 需要注意边界问题。计算机计算是从0开始的，而我们数东西是从1开始的
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        ListNode temp = dummy;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            cur = cur.next;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}
// @lc code=end
