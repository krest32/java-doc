import java.util.ArrayList;
import java.util.List;

import entrty.ListNode;

/**
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        // 奇数
        List<ListNode> odd = new ArrayList<>();
        // 偶数
        List<ListNode> idd = new ArrayList<>();
        boolean flag = true;
        while (head != null) {
            if (flag) {
                odd.add(head);
            } else {
                idd.add(head);
            }
            head = head.next;
            flag = !flag;
        }

        for (int i = 0; i < odd.size(); i++) {
            odd.get(i).next = null;
        }
        for (int i = 0; i < idd.size(); i++) {
            idd.get(i).next = null;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        int m = odd.size();
        int n = idd.size();

        for (int j = 0; j < m; j++) {
            cur.next = odd.get(j);
            cur = cur.next;
        }
        for (int j = 0; j < n; j++) {
            cur.next = idd.get(j);
            cur = cur.next;
        }
        return pre.next;

    }
}
// @lc code=end
