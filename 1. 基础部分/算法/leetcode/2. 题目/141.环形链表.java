import java.util.HashSet;
import java.util.Set;

import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        // 使用迭代方式 (快慢指针)--> 最优解
        return extracted(head);

        // 使用额外内容Set处理
        // return extracted2(head);
    }

    /**
     * 使用Set
     * 
     * Your runtime beats 22.43 % of java submissions
     * Your memory usage beats 43.9 % of java submissions (42.1 MB)
     */
    private boolean extracted2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 迭代
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 5.03 % of java submissions (42.9 MB)
     * 
     * @param head
     * @return
     */
    private boolean extracted(ListNode head) {
        if (head == null || head.next == null)
            return false;
        if (head == head.next && head.next != null)
            return true;
        // 定义连个快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            // 定义终止条件
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
// @lc code=end
