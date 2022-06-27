/*
 * @lc app=leetcode.cn id=1945 lang=java
 *
 * [1945] 字符串转化后的各位数字之和
 */

// @lc code=start
class Solution {
	public int getLucky(String s, int k) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			sb.append(c - 'a' + 1);
		}
		s = sb.toString();
		while (k-- > 0) {
			int val = 0;
			for (char c : s.toCharArray()) {
				val += c - '0';
			}
			s = String.valueOf(val);
		}
		return Integer.parseInt(s);
	}
}
// @lc code=end
