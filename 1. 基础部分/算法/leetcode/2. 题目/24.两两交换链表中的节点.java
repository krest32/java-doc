import java.util.List;

import org.omg.DynamicAny.NameDynAnyPair;

import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        // 采用迭代方式
        // return extracted2(head);

        // 递归方式--> 过于难理解
        // return extracted(head);

        // 1
        return test(head);
    }

    private ListNode test(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;

            // 进行交换操作
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            cur = node1;
        }
        return dummy.next;

    }

    /**
     * 
     * 迭代方式
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 42.74 % of java submissions (38.8 MB)
     * 
     * @param head
     * @return
     */
    private ListNode extracted2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummy.next;
    }

    /**
     * 递归方式
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 42.29 % of java submissions (38.8 MB)
     * 
     * @param head
     * @return
     */
    private ListNode extracted(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
// @lc code=end
