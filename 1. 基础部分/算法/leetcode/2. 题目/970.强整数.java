import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=970 lang=java
 *
 * [970] 强整数
 */

// @lc code=start
class Solution {
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
		Set<Integer> ans = new HashSet<>();
		int m = x == 1 ? 0 : (int) (Math.log10(bound) / Math.log10(x));
		int n = y == 1 ? 0 : (int) (Math.log10(bound) / Math.log10(y));
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				int cur = (int) Math.pow(x, i) + (int) Math.pow(y, j);
				if (cur <= bound) {
					ans.add(cur);
				}
			}
		}
		return new ArrayList<>(ans);
	}
}
// @lc code=end
