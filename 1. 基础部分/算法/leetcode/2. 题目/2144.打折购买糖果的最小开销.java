import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2144 lang=java
 *
 * [2144] 打折购买糖果的最小开销
 */

// @lc code=start
class Solution {
    public int minimumCost(int[] cost) {
        if (cost == null || cost.length == 0)
            return 0;
        int n = cost.length;
        if (n == 1)
            return cost[0];
        if (n == 2)
            return cost[0] + cost[1];
        int minCost = 0;
        Arrays.sort(cost);
        for (int i = n - 1; i >= 0; i--) {
            minCost += cost[i];
            if (i - 1 >= 0)
                minCost += cost[i - 1];
            i -= 2;
        }
        return minCost;
    }
}
// @lc code=end
