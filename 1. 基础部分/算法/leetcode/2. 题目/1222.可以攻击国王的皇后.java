import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.geometry.Side;

/*
 * @lc app=leetcode.cn id=1222 lang=java
 *
 * [1222] 可以攻击国王的皇后
 */

// @lc code=start
class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        final int SIDE = 8;
        boolean[][] chessBoard = new boolean[SIDE][SIDE];
        for(int[] queue : queens){
            chessBoard[queue[0]][queue[1]] = true;
        }
        int[][] direc = {{1,0},{1,-1},{1,1},{0,-1},{0,1},{-1,1},{-1,0},{-1,-1}};
        List<List<Integer>> queueArr = new ArrayList<>();
        for(int[] dic : direc){
            int row = king[0] + dic[0];
            int colum = king[1] + dic[1];
            while(row >=0 && row < SIDE && colum >=0 && colum< SIDE){
                if(chessBoard[row][colum]){
                    List<Integer> cur = new ArrayList<>(Arrays.asList(row,colum));
                    queueArr.add(cur);
                    break; 
                }else{
                    row += dic[0];
                    colum += dic[1];
                }
            }
        }
        return queueArr;


    }
}
// @lc code=end

