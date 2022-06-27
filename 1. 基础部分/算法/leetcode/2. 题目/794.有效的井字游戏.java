/*
 * @lc app=leetcode.cn id=794 lang=java
 *
 * [794] 有效的井字游戏
 */

// @lc code=start
class Solution {
    public boolean validTicTacToe(String[] board) {
        char[][] cs = new char[3][3];
        int x = 0, o = 0;
        // 将每个字符填入到表中
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                char c = board[i].charAt(j);
                if(c=='X') x++;
                else if(c=='O') o++;
                cs[i][j] = c;
            }
        }
        // 分情况讨论
        boolean a = check(cs,'X'), b = check(cs,'O');
        if(o>x || x-o>1) return false;
        if(a && x<=o) return false;
        if(b && o!=x) return false;
        return true;
    }

    private boolean check(char[][] cs, char c) {
        // 判断 O 或者 X 是否已经连成了一条直线
        for(int i=0; i<3; i++){
            if(cs[i][0] == c && cs[i][1] == c && cs [i][2] == c) 
                return true;
            if(cs[0][i]==c && cs[1][i] == c && cs[2][i] ==c)
                return true;
        }

        boolean a = true, b = true ;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                // 判断对角线
                if(i==j) a &= cs[i][j] == c;
                if(i+j==2) b &= cs[i][j] == c;
            }
        }

        return a||b;
    }
}
// @lc code=end

