import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        // 质数是指在大于1的自然数中，
        // 除了1和它本身以外不再有其他因数的自然数
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                ans += 1;
                // 对于一个质数 xx，如果按上文说的我们从 2x 开始标记其实是冗余的，
                // 应该直接从 xx 开始标记，因为
                // 2x,3x,… 这些数一定在 xx 之前就被其他数的倍数标记过了，
                // 例如 2 的所有倍数，3 的所有倍数等。
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end
