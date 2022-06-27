import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1019 lang=java
 *
 * [1019] 链表中的下一个更大节点
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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (head != null) {
            int ele = head.val;
            while (!stack.isEmpty() && list.get(stack.peek()) < ele) {
                list.set(stack.pop(), ele);
            }
            // 将下标索引放入到stack中
            stack.push(index);
            list.add(ele);
            index++;
            head = head.next;
        }
        while (!stack.isEmpty()) {
            list.set(stack.pop(), 0);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end
