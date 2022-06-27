
import java.util.Random;

/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
class Solution {
    int[] arr;
    int[] origin;
    Random random = new Random();
    public Solution(int[] nums) {
        arr = nums;
        origin = nums.clone();
    }
    
    public int[] reset() {
        arr = origin;
        origin = origin.clone();
        return arr;
    }
    
    public int[] shuffle() {
        for(int i=0; i<arr.length; i++){
            int rand = random.nextInt(arr.length-i)+i;
            swap(i,rand);
        }
        return arr;
    }

    private void swap(int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

