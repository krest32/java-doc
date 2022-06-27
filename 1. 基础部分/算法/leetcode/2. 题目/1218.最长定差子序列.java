import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1218 lang=java
 *
 * [1218] 最长定差子序列
 */

// @lc code=start
class Solution {
    public int longestSubsequence(int[] arr, int diff) {

        // 动态规划
        // return extracted(arr, diff);

        // 使用Map实现动态规划 --> 推荐 思路清晰
        // return extracted2(arr, diff);

        // 1
        return test(arr, diff);

    }

    private int test(int[] arr, int diff) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num - diff, 0) + 1);
            ans = Math.max(ans, map.get(num));
        }
        return ans;
    }

    /**
     * Your runtime beats 17.8 % of java submissions
     * Your memory usage beats 51.69 % of java submissions (55.8 MB)
     * 
     * @param arr
     * @param diff
     * @return
     */
    private int extracted2(int[] arr, int diff) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - diff, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

    /**
     * Your runtime beats 6.44 % of java submissions
     * Your memory usage beats 57.29 % of java submissions (55.6 MB)
     * 
     * @param arr
     * @param diff
     * @return
     */
    private int extracted(int[] arr, int diff) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] f = new int[n][2];
        f[0][1] = 1;
        map.put(arr[0], 0);
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = 1;
            int prev = arr[i] - diff;
            if (map.containsKey(prev))
                f[i][1] = Math.max(f[i][1], f[map.get(prev)][1] + 1);
            map.put(arr[i], i);
        }
        return Math.max(f[n - 1][0], f[n - 1][1]);
    }
}
// @lc code=end
