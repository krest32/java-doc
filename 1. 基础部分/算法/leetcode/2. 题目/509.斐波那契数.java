/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {

	public int fib(int n) {
		// 最优化动态规划
		// return extracted(n);

		// 普通版动态规划
		return extracted4(n);

		// 备忘录版递归
		// return extracted2(n);

		// 普通递归 会重复计算，效率低下
		// return extracted3(n);
	}

	/**
	 * Your runtime beats 100 % of java submissions
	 * Your memory usage beats 35.61 % of java submissions (38.1 MB)
	 * 
	 * @param n
	 * @return
	 */
	private int extracted4(int n) {
		// f(n) = f(n-1)+f(n-2)
		int[] dp = new int[n + 1];
		dp[0] = 0;
		if (n == 0) {
			return dp[0];
		}
		dp[1] = 1;
		if (n == 1) {
			return dp[1];
		}
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	private int extracted(int n) {
		if (n == 0) {
			return 0;
		}
		int p = 0;
		int q = 0;
		int r = 1;
		for (int i = 1; i < n; i++) {
			p = q;
			q = r;
			r = p + q;
		}
		return r;
	}

	/**
	 * Your runtime beats 100 % of java submissions
	 * Your memory usage beats 41.62 % of java submissions (38 MB)
	 *
	 * @param n
	 * @return
	 */
	private int extracted2(int n) {
		int[] memo = new int[n + 1];
		return helper(memo, n);
	}

	public int helper(int[] memo, int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (memo[n] != 0) {
			// 查询备忘录，避免重复计算
			return memo[n];
		}
		// 添加备忘录
		memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
		return memo[n];
	}

	/**
	 * Your runtime beats 23.76 % of java submissions
	 * Your memory usage beats 47.2 % of java submissions (37.9 MB)
	 *
	 * @param n
	 * @return
	 */
	private int extracted3(int n) {
		if (n < 2)
			return n;
		return extracted3(n - 1) + extracted3(n - 2);
	}
}
// @lc code=end
