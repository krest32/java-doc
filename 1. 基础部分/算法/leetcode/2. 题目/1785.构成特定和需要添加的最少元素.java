import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1785 lang=java
 *
 * [1785] 构成特定和需要添加的最少元素
 */

// @lc code=start
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums)
            sum += num;
        long differ = goal - sum;
        int answer = (int) (differ / limit);
        if (differ % limit == 0) {
            if (differ < 0)
                return -answer;
        }
        if (differ % limit != 0) {
            if (differ < 0)
                return -answer + 1;
            else
                return answer + 1;
        }
        return answer;
    }
}
// @lc code=end
