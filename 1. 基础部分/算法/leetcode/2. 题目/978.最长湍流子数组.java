
/*
 * @lc app=leetcode.cn id=978 lang=java
 *
 * [978] 最长湍流子数组
 */

// @lc code=start
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int ret= 1;
        // 定义窗口的左右边界
        int left = 0; 
        int right = 0;
        while(right<n-1){
            if(left == right){
                // 判断是否存在相同元素,left与下一个临近元素不能是相等关系
                if(arr[left] == arr[left+1]){
                    left++;
                }
                right++;
            }else{
                // 判断right周围是否是构成涡流
                if(arr[right-1] < arr[right] && arr[right] > arr[right+1]){
                    right++;
                // 判断right周围是否是构成涡流
                }else if(arr[right-1] > arr[right] && arr[right] < arr[right+1] ){
                    right++;
                }else{
                    left = right;
                }
            }
            ret = Math.max(ret, right - left +1);
        }
        return ret;
    }
}
// @lc code=end

