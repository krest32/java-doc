import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        return answer1(n, primes);
    }

    /**
     * Your runtime beats 37.17 % of java submissions
     * Your memory usage beats 18.05 % of java
     * 
     * @param n
     * @param primes
     * @return
     */
    int answer2(int n, int[] primes) {
        int m = primes.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; i++) {
            q.add(new int[] { primes[i], i, 0 });
        }
        int[] ans = new int[n];
        ans[0] = 1;
        for (int j = 1; j < n;) {
            int[] poll = q.poll();
            int val = poll[0], i = poll[1], idx = poll[2];
            if (val != ans[j - 1])
                ans[j++] = val;
            q.add(new int[] { ans[idx + 1] * primes[i], i, idx + 1 });
        }
        return ans[n - 1];
    }

    /**
     * 
     * 单路归并 ：速度更快
     * 
     * Your runtime beats 45.34 % of java submissions
     * Your memory usage beats 5.08 % of java
     * 
     * @param n
     * @param primes
     * @return
     */
    int answer1(int n, int[] primes) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        while (n-- > 0) {
            int x = queue.poll();
            if (n == 0)
                return x;
            // 符合丑数的定义，但是会进行多余的计算
            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x) {
                    queue.add(k * x);
                }
                if (x % k == 0) {
                    break;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
