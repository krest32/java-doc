import java.util.ArrayList;
import java.util.List;

import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=2130 lang=java
 *
 * [2130] 链表最大孪生和
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
    public int pairSum(ListNode head) {
        // 采用list封装链表的值，然后求取结果
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        int n1 = n - 1;
        int n2 = n >> 1;
        int max = 0;
        // 首位逐个相加，获取最大值
        for (int i = 0; i < n2; i++) {
            int cur = list.get(i) + list.get(n1 - i);
            max = Math.max(max, cur);
        }
        return max;
    }
}
// @lc code=end
