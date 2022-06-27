

/*
 * @lc app=leetcode.cn id=1574 lang=java
 *
 * [1574] 删除最短的子数组使剩余数组有序
 */

// @lc code=start
/**
 *  非常好的一道题
 */
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        // 获取左起非递增坐标
        while(left+1<n && arr[left] <= arr[left+1]){
            left++;
        }
        if(left == n-1) return 0;
        int right = n-1;
        // 反向获取非递增坐标
        while(right>0 && arr[right-1] <= arr[right]){
            right--;
        }

        // 删除完全一边的长度进行比较
        int res= Math.min(n-left-1, right);

        // 左右各保留一部分        
        int i=0;
        int j=right;
        while(i<=left && j<=n-1){
            // [0...i] 和 [j...n-1] 有序, 删除 [i+1...j-1]
            if(arr[i] <= arr[j]){
                res = Math.min(res, j-i-1);
                i++;
            }else{
                j++;
            }
        }
        return res;

    }
}
// @lc code=end

