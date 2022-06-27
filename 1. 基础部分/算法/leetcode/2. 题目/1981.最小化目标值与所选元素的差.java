

/*
 * @lc app=leetcode.cn id=1981 lang=java
 *
 * [1981] 最小化目标值与所选元素的差
 */

// @lc code=start
class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        boolean[][] dp = new boolean[mat.length+1][4900];
        for(boolean num : dp[0]){
            num = false;
        } 
        dp[0][0] = true;
        for(int i=1; i<=mat.length; i++){
            for(int j=0; j<4900; j++){
                for(int k=0; k<mat[0].length; k++){
                    if(j-mat[i-1][k]>=0 && dp[i-1][j-mat[i-1][k]] == true){
                        dp[i][j] = true;
                        break;
                    }
                    dp[i][j] = false;
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for(int j=0; j<4900; j++){
            if(dp[mat.length][j] == true){
                ret = Math.min(Math.abs(target-j), ret);
            }
        }
        return ret;
    }
}
// @lc code=end

