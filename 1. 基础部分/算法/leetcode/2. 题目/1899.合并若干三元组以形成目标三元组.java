/*
 * @lc app=leetcode.cn id=1899 lang=java
 *
 * [1899] 合并若干三元组以形成目标三元组
 */

// @lc code=start
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int a=0, b=0, c=0;
        for(int i=0; i<triplets.length; i++){
            int m1=0, m2=0, m3=0;
            // 尽可能多次交换
            if(triplets[i][0] == target[0]) m1++;
            if(triplets[i][1] == target[1]) m2++;
            if(triplets[i][2] == target[2]) m3++;
            if(triplets[i][0] > target[0] 
            || triplets[i][1] > target[1] 
            ||triplets[i][2] > target[2] ){
                m1 = 0;
                m2 = 0;
                m3 = 0;
            }
            a+=m1;
            b+=m2;
            c+=m3;
        }
        if(a>0 && b>0 && c>0){
            return true;
        }
        return false;
    }
}
// @lc code=end

