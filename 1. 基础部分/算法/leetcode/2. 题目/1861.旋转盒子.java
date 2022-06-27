/*
 * @lc app=leetcode.cn id=1861 lang=java
 *
 * [1861] 旋转盒子
 */

// @lc code=start
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        // 构建返回的二维数组
        char[][] ans = new char[n][m];
        for(int i=0; i<m; i++){
            int pos = n-1;
            for(int j=n-1; j>=0; j--){
                if(box[i][j] == '#'){
                    box[i][pos--] = '#';
                    if(pos!=j-1){
                        box[i][j] = '.';
                    }
                }else if(box[i][j] == '*'){
                    pos = j-1;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans[j][m-1-i] = box[i][j];
            }
        }
        return ans;
    }
}
// @lc code=end

