import java.util.Arrays;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        Arrays.fill(ret, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<len*2-1; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%len]){
                ret[stack.pop()] = nums[i%len];
            }
            stack.push(i%len);
        }
        return ret;
    }
}
// @lc code=end

