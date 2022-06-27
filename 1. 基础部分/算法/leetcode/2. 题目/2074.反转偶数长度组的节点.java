import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=2074 lang=java
 *
 * [2074] 反转偶数长度组的节点
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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur = head;
        int flag = 0;
        for (int j = 1; flag == 0; j++) {
            int count = 0;
            ListNode reverseHead = preHead;
            ListNode reverseTail = null;
            while (cur != null && count < j) {
                reverseTail = cur;
                preHead = preHead.next;
                cur = cur.next;
                count++;
                if (cur == null) {
                    flag = 1;
                }
            }

            if (count % 2 == 0) {
                preHead = reverse(reverseHead, reverseTail);
            }
        }
        return head;
    }

    // 反转prehead到tail区间的结点 结点顺序: prehead->(head->...->tail)
    public ListNode reverse(ListNode prehead, ListNode tail) {
        ListNode head = prehead.next;
        ListNode temp = head;
        while (temp != tail) {
            ListNode cur = temp;
            temp = temp.next;
            cur.next = tail.next;
            tail.next = cur;
        }
        prehead.next = tail;
        return head;
    }
}
// @lc code=end
