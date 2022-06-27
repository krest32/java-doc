import entrty.ListNode;
import java.util.List;

/*
 @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for sing ly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // 模拟：迭代
    // return extracted(l1, l2);

    // 1
    return test(l1, l2);
  }

  private ListNode test(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int val1 = l1 == null ? 0 : l1.val;
      int val2 = l2 == null ? 0 : l2.val;
      int sum = val1 + val2 + carry;
      carry = sum / 10;
      sum %= 10;
      ListNode temp = new ListNode(sum);
      cur.next = temp;
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
      cur = cur.next;
    }
    if (carry != 0) {
      cur.next = new ListNode(carry);
    }

    return dummy.next;
  }

  /**
   *
   *
   * @param l1
   * @param l2
   * @return
   */
  private ListNode extracted(ListNode l1, ListNode l2) {
    // 初始化变量
    ListNode pre = new ListNode(-1);
    ListNode cur = pre;

    int carry = 0;

    // 两个链表都不为空的情况下，进行累加
    while (l1 != null || l2 != null) {
      // 空值判断
      int n1 = l1 == null ? 0 : l1.val;
      int n2 = l2 == null ? 0 : l2.val;

      // 计算数值
      int sum = n1 + n2 + carry;
      carry = sum / 10;
      sum = sum % 10;

      // 执行链表的迭代操作
      cur.next = new ListNode(sum);
      cur = cur.next;
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    // 判断最后节点相加，是否进位
    if (carry == 1) {
      cur.next = new ListNode(1);
    }
    return pre.next;
  }
}
// @lc code=end
