import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=923 lang=java
 *
 * [923] 三数之和的多种可能
 */

// @lc code=start
class Solution {
    int ans = 0;

    public int threeSumMulti(int[] A, int target) {
        int MOD = 1_000_000_007;
        long ans = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length; ++i) {
            int T = target - A[i];
            int j = i + 1;
            int k = A.length - 1;
            while (j < k) {
                // These steps proceed as in a typical two-sum.
                if (A[j] + A[k] < T)
                    j++;
                else if (A[j] + A[k] > T)
                    k--;
                else if (A[j] != A[k]) {
                    int left = 1, right = 1;
                    while (j + 1 < k && A[j] == A[j + 1]) {
                        left++;
                        j++;
                    }
                    while (k - 1 > j && A[k] == A[k - 1]) {
                        right++;
                        k--;
                    }
                    ans += left * right;
                    ans %= MOD;
                    j++;
                    k--;
                } else {
                    ans += (k - j + 1) * (k - j) / 2;
                    ans %= MOD;
                    break;
                }
            }
        }

        return (int) ans;

    }
}
// @lc code=end
