import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=728 lang=java
 *
 * [728] 自除数
 */

// @lc code=start
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        // 暴力
        List<Integer> ans = new ArrayList<>();
        for (int n = left; n <= right; n++) {
            // 判断是否是自除数
            if (selfDividing(n))
                ans.add(n);
        }
        return ans;
    }

    public boolean selfDividing(int n) {
        for (char c : String.valueOf(n).toCharArray()) {
            if (c == '0' || (n % (c - '0') > 0))
                return false;
        }
        return true;
    }
}
// @lc code=end
