/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int index = 0;
        for(int i=0; i<len; i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index ++;
            }
        }
        for(int i=0; i<len; i++){
            if(nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index ++;
            }
        }
    }
}
// @lc code=end

