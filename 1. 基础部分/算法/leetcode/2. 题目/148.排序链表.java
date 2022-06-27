import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entrty.ListNode;

/**
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).next = null;
        }
        list.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        for (int i = 0; i < list.size(); i++) {
            cur.next = list.get(i);
            cur = cur.next;
        }
        return pre.next;

    }
}
// @lc code=end
