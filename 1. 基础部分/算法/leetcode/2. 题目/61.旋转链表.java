import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {

        // 迭代
        // return extracted(head, k);

        // 1
        return test(head, k);
    }

    private ListNode test(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        int len = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            len++;
        }
        k = len - k % len;
        if (k == len)
            return head;
        iter.next = head;
        while (k-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

    private ListNode extracted(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }

        int add = n - k % n;
        if (add == n) {
            return head;
        }
        // 首尾相连，形成环形链表
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}
// @lc code=end
