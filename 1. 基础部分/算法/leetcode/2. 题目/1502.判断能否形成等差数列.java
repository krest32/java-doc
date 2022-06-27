import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1502 lang=java
 *
 * [1502] 判断能否形成等差数列
 */

// @lc code=start
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        // 最简单的写法 -> 排序
        Arrays.sort(arr);
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] - arr[i - 2] != arr[i] - arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
