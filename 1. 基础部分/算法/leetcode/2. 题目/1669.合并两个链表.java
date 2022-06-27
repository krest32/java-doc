/*
 * @lc app=leetcode.cn id=1669 lang=java
 *
 * [1669] 合并两个链表
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 哑元节点
        ListNode ans = new ListNode();
        ans.next = list1;
        ListNode l = list1;
        int move = a;
        while (move > 1) {
            l = l.next;
            move--;
        }
        b = b - a;
        ListNode r = l;
        while (b > -1) {
            r = r.next;
            b--;
        }
        l.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = r.next;
        return ans.next;
    }
}
// @lc code=end
