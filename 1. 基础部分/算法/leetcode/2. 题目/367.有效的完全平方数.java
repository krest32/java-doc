/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        // 二分查找
        return extracted(num);

        // 暴力
        // return extracted2(num);
    }

    /**
     * Your runtime beats 9.93 % of java submissions
     * Your memory usage beats 38.95 % of java submissions (38 MB)
     * 
     * @param num
     * @return
     */
    private boolean extracted2(int num) {
        long x = 1, square = 1;
        while (square <= num) {
            if (square == num) {
                return true;
            }
            x++;
            square = x * x;
        }
        return false;
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 21.88 % of java submissions (38.2 MB)
     * 
     * @param num
     * @return
     */
    private boolean extracted(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
