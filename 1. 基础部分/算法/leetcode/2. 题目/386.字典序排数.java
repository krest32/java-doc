import java.util.List;

/*
 * @lc app=leetcode.cn id=386 lang=java
 *
 * [386] 字典序排数
 */

// @lc code=start
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, i, ret);
        }
        return ret;

    }

    private void dfs(int n, int i, List<Integer> ret) {
        if (i > n) {
            return;
        }
        ret.add(i);
        for (int j = 0; j <= 9; j++) {
            dfs(n, i * 10 + j, ret);
        }
    }
}
// @lc code=end
