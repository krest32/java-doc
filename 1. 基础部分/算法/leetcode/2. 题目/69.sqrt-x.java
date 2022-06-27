import java.util.logging.FileHandler;

/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        long index =0;
        while(left<=right){
            long mid = left+(right-left)/2;
            if(mid*mid<=x){
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

