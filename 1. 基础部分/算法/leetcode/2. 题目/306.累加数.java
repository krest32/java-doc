import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {

    /**
     * 存在一定难度，虽然理解了，但是很勉强
     */
    String num;
    int n;
    List<List<Integer>> list = new ArrayList<>();

    public boolean isAdditiveNumber(String _num) {
        num = _num;
        n = num.length();
        return dfs(0);
    }

    private boolean dfs(int u) {
        int m = list.size();
        // 判断List中是否有多余的累加数，如果有，证明字符串非累加数
        if (u == n) {
            return m >= 3;
        }
        // 动态获取list应该截取字符串的最大长度位置
        int max = num.charAt(u) == '0' ? u + 1 : n;
        List<Integer> cur = new ArrayList<>();
        for (int i = u; i < max; i++) {
            // 向索引位置添加第一个非0元素
            cur.add(0, num.charAt(i) - '0');
            // 判断当前list中是否满足累加数
            if (m < 2 || check(list.get(m - 2), list.get(m - 1), cur)) {
                list.add(cur);
                if (dfs(i + 1)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }

        return false;
    }

    /**
     * 每个list中存入一个数字，代表存入的一个数，
     * A+B 判断最终是否 = c？
     */
    private boolean check(List<Integer> a, List<Integer> b, List<Integer> c) {
        List<Integer> ans = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < a.size() || i < b.size(); i++) {
            if (i < a.size()) {
                t += a.get(i);
            }
            if (i < b.size()) {
                t += b.get(i);
            }
            ans.add(t % 10);
            t /= 10;
        }

        if (t > 0) {
            ans.add(t);
        }

        boolean ok = c.size() == ans.size();
        for (int i = 0; i < c.size() && ok; i++) {
            if (c.get(i) != ans.get(i)) {
                ok = false;
            }
        }
        return ok;
    }
}
// @lc code=end
