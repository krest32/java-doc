/*
 * @lc app=leetcode.cn id=1936 lang=java
 *
 * [1936] 新增的最少台阶数
 */

// @lc code=start
class Solution {
    public int addRungs(int[] rungs, int dist) {
        // 加法 ： 案例全部通过，但是超时
        // return extracted(rungs, dist);

        // 除法 100%
        return extracted2(rungs, dist);

    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 50.3 % of java submissions (52.9 MB)
     * 
     * @param rungs
     * @param dist
     * @return
     */
    private int extracted2(int[] rungs, int dist) {
        int ans = 0;
        int len = rungs.length;
        int last = 0;
        int cur;
        for (int i = 0; i < len; i++) {
            cur = rungs[i];
            if (cur - last > dist) {
                // 注意边界问题
                int diff = cur - last - 1;
                ans += diff / dist;
            }
            last = cur;
        }
        return ans;
    }

    /**
     * Time Limit Exceeded
     * 117/117 cases passed (N/A)
     * 
     * @param rungs
     * @param dist
     * @return
     */
    private int extracted(int[] rungs, int dist) {
        int ans = 0;
        int len = rungs.length;
        int last = 0;
        int cur;
        for (int i = 0; i < len; i++) {
            cur = rungs[i];
            if (cur - last > dist) {
                while (last + dist < cur) {
                    last += dist;
                    ans++;
                }
            }
            last = cur;
        }
        return ans;
    }
}
// @lc code=end
