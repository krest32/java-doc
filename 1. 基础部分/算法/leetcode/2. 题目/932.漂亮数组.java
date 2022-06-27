import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=932 lang=java
 *
 * [932] 漂亮数组
 */

// @lc code=start
class Solution {
    Map<Integer, int[]> memo;

    public int[] beautifulArray(int n) {
        memo = new HashMap<>();
        return dfs(n);
    }

    private int[] dfs(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int[] ans = new int[n];
        if (n == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            for (int x : dfs((n + 1) / 2)) {
                ans[t++] = 2 * x - 1;
            }
            for (int x : dfs(n / 2)) {
                ans[t++] = 2 * x;
            }
        }
        memo.put(n, ans);
        return ans;
    }
}
// @lc code=end
