import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2178 lang=java
 *
 * [2178] 拆分成最多数目的正偶数之和
 */

// @lc code=start
class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        // 数学模拟
        return extracted(finalSum);
    }

    /**
     * Your runtime beats 97.48 % of java submissions
     * Your memory usage beats 17.6 % of java submissions (59 MB)
     */
    private List<Long> extracted(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return ans;
        }

        for (long sum = finalSum, even = 2; sum > 0; sum -= even, even += 2) {
            // 不够拆分，将剩余的部分追加给最后一个元素
            if (sum < even) {
                int idx = ans.size() - 1;
                long t = ans.get(idx) + sum;
                ans.set(idx, t);
                break;
            }
            ans.add(even);
        }

        return ans;
    }
}
// @lc code=end
