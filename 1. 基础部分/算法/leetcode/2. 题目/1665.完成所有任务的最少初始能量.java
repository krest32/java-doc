import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1665 lang=java
 *
 * [1665] 完成所有任务的最少初始能量
 */

// @lc code=start
class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (o1, o2) -> {
            return o1[0] - o1[1] - o2[0] + o2[1];
        });
        int ans = 0;
        for (int i = tasks.length - 1; i >= 0; i--) {
            ans = Math.max(ans + tasks[i][0], tasks[i][1]);
        }
        return ans;
    }
}
// @lc code=end
