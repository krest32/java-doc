/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        return dfs(Math.min(10, n), 0, new boolean[10]);
    }

    int dfs(int n, int idx, boolean[] used) {
        int count = 0;
        if (idx < n) {
            for (int i = 0; i < 10; i++) {
                // 剪枝：多位数，第一个字符不能为0
                if (used[i] || (i == 0 && idx == 1)) {
                    continue;
                }
                used[i] = true;
                count += dfs(n, idx + 1, used) + 1;
                used[i] = false;
            }
        }
        return count;
    }
}
// @lc code=end
