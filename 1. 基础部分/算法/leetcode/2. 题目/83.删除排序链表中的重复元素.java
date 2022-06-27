
import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 迭代
        // return extracted(head);

        // 2
        return test(head);

    }

    private ListNode test(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    /**
     * 166/166 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 80.18 % of java submissions (40.8 MB)
     * 
     * @param head
     * @return
     */
    private ListNode extracted(ListNode head) {
        // 定义哑元节点
        ListNode pre = new ListNode(-1);
        pre.next = head;
        // 开始进行迭代
        while (head != null) {
            // 如果存在重复的节点，就跳转下一个节点
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return pre.next;
    }
}
// @lc code=end
