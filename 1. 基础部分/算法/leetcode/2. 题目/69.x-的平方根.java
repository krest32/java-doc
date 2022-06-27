

/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        // 定义出事变量，因为乘积的值可能很大，所以使用long
        long left = 0, right = x, index=0;
        // 执行二分查找法
        while(left<=right){
            long mid = left+(right-left)/2;
            if(mid*mid <= x){
                index = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return (int)index;
    }   
}
// @lc code=end

