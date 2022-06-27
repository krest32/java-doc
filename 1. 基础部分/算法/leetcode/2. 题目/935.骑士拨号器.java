

/*
 * @lc app=leetcode.cn id=935 lang=java
 *
 * [935] 骑士拨号器
 *  每个数字及可达数字为：
 *   0 -> 4, 6
 *   1 -> 6, 8
 *   2 -> 7, 9
 *   3 -> 4, 8
 *   4 -> 3, 9, 0
 *   5 ->
 *   6 -> 1, 7, 0
 *   7 -> 2, 6
 *   8 -> 1, 3
 *   9 -> 4, 2
 *  设dp[time][num] 表示骑士第time次跳到数字num时组成的不同号码的个数
 *  那么要实现第time次跳到数字num,那么就要保证第time-1次跳到num的可达数字
 *  也就是说dp[time][num]是第time-1跳到num的所有可达数字的dp的总和
 *  最后返回要求dp[N-1][]的值
 */

// @lc code=start
class Solution {
    // 行下标为起点num,每一行的所有数据为可达数字
    private int[][] path = { { 4, 6 }, { 6, 8 }, { 7, 9 },
            { 4, 8 }, { 3, 9, 0 }, {}, { 1, 7, 0 },
            { 2, 6 }, { 1, 3 }, { 4, 2 } };
    private static final int MOD = 1000000007;

    public int knightDialer(int N) {
        // 普通二维数组 dp
        return extracted(N);

        // 记忆化递归
        // return extracted2(N);

        
    }

    /**
     * Your runtime beats 17.81 % of java submissions
     * Your memory usage beats 32.42 % of java submissions (40.8 MB)
     * 
     * @param N
     * @return
     */
    private int extracted2(int N) {
        int[][] memo = new int[N][10];
        int res = 0;
        for (int num = 0; num < 10; num++)
            res = (res + helper(N - 1, num, memo, path)) % MOD;
        return res;
    }

    private int helper(int n, int num, int[][] memo, int[][] path) {
        if (n == 0)
            return 1;
        if (memo[n][num] != 0) // 如果已经算过
            return memo[n][num];
        int res = 0;
        for (int neighbor : path[num])
            res = (res + helper(n - 1, neighbor, memo, path)) % MOD;
        return memo[n][num] = res;
    }

    /**
     * Your runtime beats 51.6 % of java submissions
     * Your memory usage beats 26.49 % of java submissions (41 MB)
     * 
     * @param N
     * @return
     */
    private int extracted(int N) {
        // dp[i][j] 表示跳跃 i 次，到达 j 位置会有多少中不同的组合
        int[][] dp = new int[N][10];
        for (int num = 0; num < 10; num++)
            // 第0次（跳到）num的不同号码个数为1
            dp[0][num] = 1;

        for (int time = 1; time < N; time++) {
            for (int num = 0; num < 10; num++) {
                // 再去遍历可以到达的种类数量
                for (int arrive : path[num])
                    dp[time][num] = (dp[time][num]
                            + dp[time - 1][arrive]) % MOD;
            }
        }
        int res = 0;
        for (int num = 0; num < 10; num++)
            res = (res + dp[N - 1][num]) % MOD;
        return res;
    }
}
// @lc code=end
