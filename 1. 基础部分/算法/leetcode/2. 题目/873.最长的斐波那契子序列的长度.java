import java.util.*;

/*
 * @lc app=leetcode.cn id=873 lang=java
 *
 * [873] 最长的斐波那契子序列的长度
 */

// @lc code=start
class Solution {

    public int lenLongestFibSubseq(int[] arr) {
        /**
         * 前两种方法都没有利用到有序这一个条件
         */

        // 暴力解法+备忘录
        // return extracted(arr);

        // 动态规划
        // return extracted2(arr);

        // 动态规划+二分 --> 速度最优解
        return extracted3(arr);

    }

    /**
     * Your runtime beats 96.5 % of java submissions
     * Your memory usage beats 7 % of java submissions (50.5 MB)
     * 
     * @param arr
     * @return
     */
    private int extracted3(int[] arr) {
        int max = 0;
        int len = arr.length;
        int[][] dp = new int[len][len];

        for (int end = 2; end < len; end++) {
            int L = 0, R = end - 1;
            while (L < R) {
                if (arr[L] + arr[R] == arr[end]) {
                    if (dp[L][R] == 0) {
                        dp[L][R] = 2;
                        dp[R][end] = 3;
                    } else {
                        dp[R][end] = dp[L][R] + 1;
                    }
                    max = Math.max(dp[R][end], max);
                    L++;
                    R--;
                } else if (arr[L] + arr[R] < arr[end]) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return max;
    }

    /**
     * Your runtime beats 58.02 % of java submissions
     * Your memory usage beats 63.57 % of java submissions (41.6 MB)
     * 
     * @param arr
     * @return
     */
    private int extracted2(int[] arr) {
        int N = arr.length;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < N; ++i)
            index.put(arr[i], i);

        Map<Integer, Integer> longest = new HashMap<>();
        int ans = 0;

        for (int k = 0; k < N; ++k)
            for (int j = 0; j < k; ++j) {
                int i = index.getOrDefault(arr[k] - arr[j], -1);
                if (i >= 0 && i < j) {
                    // Encoding tuple (i, j) as integer (i * N + j)
                    int cand = longest.getOrDefault(i * N + j, 2) + 1;
                    longest.put(j * N + k, cand);
                    ans = Math.max(ans, cand);
                }
            }

        return ans >= 3 ? ans : 0;
    }

    /**
     * Your runtime beats 23.16 % of java submissions
     * Your memory usage beats 5.07 % of java submissions (51.1 MB)
     * 
     * 1. 优化策略： 使用二维数组，由于元素不重复，所以利用求余计算出对应的坐标位置
     * 
     * @param arr
     * @return
     */
    private int extracted(int[] arr) {
        int len = arr.length;
        int maxValue = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
            maxValue = Math.max(maxValue, num);
        }
        // len+1 避免越界
        int[][] memo = new int[len][len];
        int idx1 = 0;
        int idx2 = idx1 + 1;
        int sum = 0;
        while (idx1 < len) {
            int cur = arr[idx1];
            while (idx2 < len && sum + idx2 <= len) {
                int last = arr[idx2];
                int num = check(cur, last, set, memo);
                sum = Math.max(sum, num);
                idx2++;
            }
            idx1++;
            idx2 = idx1 + 1;
        }
        return sum == 2 ? 0 : sum;
    }

    private int check(int cur, int last, Set<Integer> set, int[][] memo) {
        int target = cur + last;
        int len = memo.length;
        if (set.contains(target)) {
            if (memo[cur % len][last % len] == 0) {
                // 此处两个数字不能写反
                int ret = check(last, target, set, memo) + 1;
                memo[cur % len][last % len] = ret;
                return ret;
            }
            return memo[cur % len][last % len];
        }
        return 2;
    }
}
// @lc code=end
