import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2178 lang=java
 *
 * [2178] 拆分成最多数目的偶整数之和
 */

// @lc code=start
class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 == 1) {
            return res;
        }

        long cur = 0L;
        long x = 2;
        while (cur + x <= finalSum) {
            res.add(x);
            cur += x;
            x += 2;
        }

        long diff = finalSum - cur;
        if (diff != 0) {
            long tmp = res.get(res.size() - 1);
            res.set(res.size() - 1, tmp + diff);
        }
        return res;
    }
}
// @lc code=end
