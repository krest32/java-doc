import java.util.ArrayList;
import java.util.List;

/**
 * @lc app=leetcode.cn id=22 lang=java
 *
 *     [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        // 回溯
        return extracted(n);
    }

    private List<String> extracted(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, new StringBuilder(), n, 0, 0);
        return res;
    }

    private void backTrack(List<String> res, StringBuilder temp, int n, int left, int right) {
        // 终止条件
        if (temp.length() == n * 2) {
            res.add(temp.toString());
            return;
        }
        // 括号左边计数
        if (left < n) {
            temp.append("(");
            backTrack(res, temp, n, left + 1, right);
            temp.deleteCharAt(temp.length() - 1);
        }
        // 括号右边数，右边不能大于左边
        if (right < left) {
            temp.append(")");
            backTrack(res, temp, n, left, right + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
// @lc code=end
