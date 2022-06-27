import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] 删除无效的括号
 */

// @lc code=start
class Solution {
    Set<String> set = new HashSet<>();
    int n, max, len;
    String s;

    public List<String> removeInvalidParentheses(String _s) {
        s = _s;
        n = s.length();
        int left = 0;
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
            }
        }
        // 获取最小应有的对数
        max = Math.min(left, right);
        dfs(0, "", 0);
        return new ArrayList<>(set);

    }

    /**
     * 
     * @param u     当前字符串执行到的指针位置
     * @param cur   新生成的字符串
     * @param score 代表左边括号的数量
     */
    private void dfs(int u, String cur, int score) {
        if (score < 0 || score > max) {
            return;
        }
        // 最终终止条件
        if (u == n) {
            if (score == 0 && cur.length() >= len) {
                // 进行剪枝
                len = cur.length();
                set.add(cur);
            }
            return;
        }

        char c = s.charAt(u);
        if (c == '(') {
            dfs(u + 1, cur + String.valueOf(c), score + 1);
            // 为剪枝进行操作
            dfs(u + 1, cur, score);
        } else if (c == ')') {
            dfs(u + 1, cur + String.valueOf(c), score - 1);
            // 为剪枝进行操作
            dfs(u + 1, cur, score);
        } else {
            dfs(u + 1, cur + String.valueOf(c), score);
        }

    }
}
// @lc code=end
