/*
 * @lc app=leetcode.cn id=1780 lang=java
 *
 * [1780] 判断一个数字是否可以表示成三的幂的和
 */

// @lc code=start
class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n > 0){
            int di = n % 3;
            if(di == 2){
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
// @lc code=end

