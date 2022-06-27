/*
 * @lc app=leetcode.cn id=1201 lang=java
 *
 * [1201] 丑数 III
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        // 二分查找
        return extracted(n, a, b, c);

        // 暴力 --> 超时
        // return extracted2(n, a, b, c);


    }

    private int extracted2(int n, int a, int b, int c) {
        long max = (long) Math.max(a, Math.max(c, b));
        long end = max * n;
        int count = 0;
        long ans = 0;
        for (long i = 1; i < end; i++) {
            if (i % a == 0 || i % b == 0 || i % c == 0) {
                count++;
                if (count == n) {
                    ans = i;
                    break;
                }
            }
        }
        return (int) ans;
    }

    private int extracted(int n, int a, int b, int c) {
        long ans = 0;
        long l = 0, r = (long) Math.min(a, Math.min(b, c)) * n;
        long ab = this.lcm(a, b);
        long ac = this.lcm(a, c);
        long bc = this.lcm(b, c);
        long abc = this.lcm(b, ac);
        while (l <= r) {
            long m = l + ((r - l) >> 1);
            long N = m / a + m / b + m / c - m / ab - m / ac - m / bc + m / abc;
            if (N < n) {
                l = m + 1;
                ans = l;
            } else {
                r = m - 1;
            }
        }
        return (int) ans;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
// @lc code=end
