import java.util.HashSet;
import java.util.Set;

import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 解法一 迭代
        // return extracted(headA, headB);

        // 解法二 哈希
        return extracted2(headA, headB);

    }

    /**
     * 哈希
     * 
     * Your runtime beats 18.78 % of java submissions
     * Your memory usage beats 53.31 % of java submissions (43.5 MB)
     * 
     * @param headA
     * @param headB
     * @return
     */
    private ListNode extracted2(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 迭代
     * 
     * Your runtime beats 99.25 % of java submissions
     * Your memory usage beats 11.46 % of java submissions (44.5 MB)
     * 
     * @param headA
     * @param headB
     * @return
     */
    private ListNode extracted(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;

        // 彼此走对方的路，然后在相同的地点遇到
        // 原理：A、B 在相交链表中，走过的节点个数相同
        while (A != B) {
            if (A != null) {
                A = A.next;
            } else {
                A = headB;
            }

            if (B != null) {
                B = B.next;
            } else {
                B = headA;
            }
        }
        return A;
    }
}
// @lc code=end
