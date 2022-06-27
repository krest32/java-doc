/*
 * @lc app=leetcode.cn id=2048 lang=java
 *
 * [2048] 下一个更大的数值平衡数
 */

// @lc code=start
class Solution {

    public int nextBeautifulNumber(int n) {
        // 深度模拟
        return extracted(n);
    }

    /**
     * 145/145 cases passed (97 ms)
     * Your runtime beats 56.25 % of java submissions
     * Your memory usage beats 52.84 % of java submissions (40.8 MB)
     * 
     * @param n
     * @return
     */
    private int extracted(int n) {
        int num = n + 1;
        while (check(num) == false) {
            num++;
        }
        return num;
    }

    public boolean check(int num) {
        int[] cnt = new int[10];
        // 记录每个数字出现的次数
        while (num != 0) {
            int x = num % 10;
            cnt[x]++;
            num /= 10;
        }

        for (int x = 0; x < 10; x++) {
            if (cnt[x] != 0 && x != cnt[x]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
