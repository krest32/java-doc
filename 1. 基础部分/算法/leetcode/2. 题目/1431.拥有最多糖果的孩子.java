import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1431 lang=java
 *
 * [1431] 拥有最多糖果的孩子
 */

// @lc code=start
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxValue = 0;
        for (int candy : candies) {
            maxValue = Math.max(maxValue, candy);
        }
        List<Boolean> ret = new ArrayList<>();
        for (int candy : candies) {
            ret.add((candy + extraCandies) >= maxValue);
        }
        return ret;
    }
}
// @lc code=end
