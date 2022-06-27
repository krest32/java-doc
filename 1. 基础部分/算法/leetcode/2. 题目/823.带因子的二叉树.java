import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=823 lang=java
 *
 * [823] 带因子的二叉树
 */

// @lc code=start
class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1000000007;
        int N = A.length;
        Arrays.sort(A);
        // 每个节点可以组成的二叉树的数量
        long[] dp = new long[N];
        Arrays.fill(dp, 1);
        // 每个数字的值和坐标
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            index.put(A[i], i);
        }

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < i; ++j) {
                // A[j] is left child
                if (A[i] % A[j] == 0) { 
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }

        long ans = 0;
        for (long x : dp){
            ans += x;
        }
        return (int) (ans % MOD);
    }
}
// @lc code=end
