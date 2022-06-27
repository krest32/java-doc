/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        // 解法一：双指针
        // return extracted(nums);

        // 解法二： 双指针优化： 空间度优化
        return extracted2(nums);
    }

    /**
     * 双指针优化
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 21.54 % of java submissions (43 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                // 增加一个双指针的判断
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }

    /**
     * 双指针
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 5.09 % of java submissions (43.3 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        // 定义双指针
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // j 代表不重复的元素指针，
            // 直接替换数组中出现的相同元素
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
// @lc code=end
