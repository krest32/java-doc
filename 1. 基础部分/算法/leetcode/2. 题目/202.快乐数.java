import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        // 解法一 快慢双指针 --> 最优解法
        // return extracted(n);

        // 解题二 哈希
        return extracted2(n);
    }

    /**
     * 哈希
     * 
     * Your runtime beats 82.15 % of java submissions
     * Your memory usage beats 8.86 % of java submissions (38.9 MB)
     * 
     * @param n
     * @return
     */
    private boolean extracted2(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /**
     * 快慢双指针
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 49.1 % of java submissions (38.3 MB)
     * 
     * @param n
     * @return
     */
    private boolean extracted(int n) {
        // 存在两种结果
        // 1. n 是快乐数 2. n在某个数字的平方和中一直循环
        int slow = n;
        int fast = getNext(n);
        // 快慢指针得出结果，如果最终slow==fast，代表进入了死循环
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}
// @lc code=end
