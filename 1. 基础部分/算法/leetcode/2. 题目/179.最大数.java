import java.util.Arrays;

/**
 * @lc app=leetcode.cn id=179 lang=java
 *
 *     [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        Integer[] numArr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numArr[i] = nums[i];
        }
        Arrays.sort(numArr, (x, y) -> {
            long sx = 10;
            long sy = 10;
            while (sx <= x) {
                sx = sx * 10;
            }
            while (sy <= y) {
                sy = sy * 10;
            }

            return (int) ((sx * y + x) - (sy * x + y));
        });
        if (numArr[0] == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numArr.length; i++) {
            res.append(numArr[i].toString());
        }
        return res.toString();

    }
}
// @lc code=end
