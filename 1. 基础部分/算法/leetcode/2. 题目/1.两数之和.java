import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 *
 */

// @lc code=start
class Solution {

  public int[] twoSum(int[] nums, int target) {
    // return extracted1(nums, target);

    // return extracted2(nums, target);

    // 1
    return test(nums, target);
  }

  private int[] test(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[] { map.get(target - nums[i]), i };
      }
      map.put(nums[i], i);
    }
    return new int[0];
  }

  /**
   *
   * 暴力解法
   *
   * Your runtime beats 26 % of java submissions
   * Your memory usage beats 24.33 % of java submissions (41.5 MB)
   *
   * @param nums
   * @param target
   * @return
   */
  private int[] extracted2(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] { i, j };
        }
      }
    }
    return new int[0];
  }

  /**
   * 一次遍历 + 哈希表
   * 速度和效率都有明显提高
   *
   * Your runtime beats 99.42 % of java submissions
   * Your memory usage beats 37.83 % of java submissions (41.3 MB)
   *
   * @param nums
   * @param target
   * @return
   */
  private int[] extracted1(int[] nums, int target) {
    // 用来记录数组中的值与下标
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      // 判断是否存在差值
      if (map.containsKey(target - nums[i])) {
        return new int[] { map.get(target - nums[i]), i };
      }
      map.put(nums[i], i);
    }
    return new int[0];
  }
}
// @lc code=end
