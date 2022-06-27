import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
    public ListNode removeElements(ListNode head, int val) {
        // 迭代
        // return extracted(head, val);

        // 递归
        return extracted2(head, val);
    }

    /**
     * 递归
     * 
     * @param head
     * @param val
     * @return
     */
    private ListNode extracted2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 迭代
     * 
     * @param head
     * @param val
     * @return
     */
    private ListNode extracted(ListNode head, int val) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        cur.next = head;
        // 迭代链表，去掉目标元素
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }
}
// @lc code=end
