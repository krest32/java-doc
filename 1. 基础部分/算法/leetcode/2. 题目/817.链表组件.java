import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=817 lang=java
 *
 * [817] 链表组件
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
    public int numComponents(ListNode head, int[] nums) {
        // 模拟
        return extracted(head, nums);
    }

    /**
     * 57/57 cases passed (602 ms)
     * Your runtime beats 5.17 % of java submissions
     * Your memory usage beats 90.96 % of java submissions (41.6 MB)
     * 
     * @param head
     * @param nums
     * @return
     */
    private int extracted(ListNode head, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int cnt = 0;
        int ans = 0;
        while (head != null) {
            if (list.contains(head.val)) {
                cnt++;
            } else {
                if (cnt != 0) {
                    ans++;
                }
                cnt = 0;
            }
            head = head.next;
        }
        if (cnt != 0) {
            ans++;
        }
        return ans;
    }
}
// @lc code=end
