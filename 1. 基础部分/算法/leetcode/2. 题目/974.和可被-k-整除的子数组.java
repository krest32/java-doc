/*
 * @lc app=leetcode.cn id=974 lang=java
 *
 * [974] 和可被 K 整除的子数组
 */

// @lc code=start
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        // 暴力超时
        // return extracted(A, K);

        // 计数
        // 故若想 (sum[j] - sum[i])%K = (sum[j]−sum[i])%K =0 ，
        // 则必有 sum[j]%K = sum[i]%K。
        return extracted2(A, K);

    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 60.75 % of java submissions (45.1 MB)
     * 
     * @param A
     * @param K
     * @return
     */
    private int extracted2(int[] A, int K) {
        int N = A.length, sum = 0, ans = 0;
        int[] map = new int[K];
        map[0] = 1;
        for (int i = 1; i <= N; i++) {
            sum = sum + A[i - 1];
            // 注意 Java 取模的特殊性，
            // 当被除数为负数时取模结果为负数，需要纠正
            int key = (sum % K + K) % K;
            ans += map[key];
            map[key]++;
        }
        return ans;
    }

    private int extracted(int[] A, int K) {
        int N = A.length, ans = 0;
        int[] sum = new int[N + 1];

        for (int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] + A[i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int res = sum[j] - sum[i];
                if (res % K == 0)
                    ans++;
            }
        }
        return ans;
    }

}
// @lc code=end
