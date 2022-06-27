import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=1029 lang=java
 *
 * [1029] 两地调度
 */

// @lc code=start
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // 根据数组的差值进行排序
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });

        int total = 0;
        int n = costs.length / 2;
        // 选出 price_A - price_B 最小的 N 个人，让他们飞往 A 市，其余人飞往 B 市
        for (int i = 0; i < n; ++i)
            total += costs[i][0] + costs[i + n][1];
        return total;
    }
}
// @lc code=end
