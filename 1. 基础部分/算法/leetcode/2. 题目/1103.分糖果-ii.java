/*
 * @lc app=leetcode.cn id=1103 lang=java
 *
 * [1103] 分糖果 II
 */

// @lc code=start
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        // 暴力枚举
        return extracted(candies, num_people);
    }

    private int[] extracted(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0;
        // 暴力一直分糖
        while (candies != 0) {
            // 求余获取人的坐标
            ans[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
            i += 1;
        }
        return ans;
    }
}
// @lc code=end
