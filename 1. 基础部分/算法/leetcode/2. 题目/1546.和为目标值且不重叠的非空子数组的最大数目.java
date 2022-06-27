import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1546 lang=java
 *
 * [1546] 和为目标值且不重叠的非空子数组的最大数目
 */

// @lc code=start
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int size = nums.length;
        int ret = 0;
        int start = 0;
        while(start < size){
            Set<Integer> set = new HashSet<>();
            set.add(0);
            int sum = 0;
            while(start < size){
                // 记录当前值和，同时保证不重复
                sum += nums[start];
                if(set.contains(sum-target)){
                    // 记录满足条件的结果数
                    ret++;
                    break;
                }else{
                    set.add(sum);
                    // 元素不能够别重复使用；
                    start++;
                }
            }
            start++;
        }  
        return ret;

    }
}
// @lc code=end

