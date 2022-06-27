
import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 
 * 
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        /**
         * 两种解法都没有涉及到多次遍历，所以算法时间不会有太大的差异
         * 但是递归的写法相对与迭代来说，更加简洁
         */

        // 解法一： 迭代
        // return extracted(list1, list2);

        // 解法二： 递归
        return extracted2(list1, list2);
    }

    /**
     * 递归
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 23.17 % of java submissions (40.9 MB)
     * 
     * @param list1
     * @param list2
     * @return
     */
    private ListNode extracted2(ListNode list1, ListNode list2) {
        // 先处理边界情况
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
            // 比较大小
        } else if (list1.val < list2.val) {
            list1.next = extracted2(list1.next, list2);
            return list1;
        } else {
            list2.next = extracted2(list1, list2.next);
            return list2;
        }
    }

    /**
     * 迭代算法
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 16.35 % of java submissions (41 MB)
     * 
     * @param list1
     * @param list2
     * @return
     */
    private ListNode extracted(ListNode list1, ListNode list2) {
        // 初始化节点
        ListNode pre = new ListNode();
        ListNode cur = pre;

        // 对 listNode 进行迭代
        while (list1 != null || list2 != null) {

            // 执行判空操作
            if (list1 == null) {
                cur.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                cur.next = list1;
                list1 = list1.next;

                // 执行比较操作
            } else if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }

            // 对当前节点进行迭代
            cur = cur.next;
        }

        // 返回结果
        return pre.next;
    }
}
// @lc code=end
