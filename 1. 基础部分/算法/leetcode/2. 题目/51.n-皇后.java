import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    int len;
    char[][] p;
    // 下面的数组含义分别为：列、对角线、反对角线
    boolean col[], dg[], bdg[];

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        len = n;
        // 开2n倍空间防止数组越界
        p = new char[n][n];
        col = new boolean[2 * n];
        dg = new boolean[2 * n];
        bdg = new boolean[2 * n];
        // 初始化棋盘数组p
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                p[i][j] = '.';

        dfs(0);

        return ans;

    }

    public void dfs(int u) {
        // 递归出口条件
        if (u == len) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                tmp.add(String.copyValueOf(p[i]));
            }
            ans.add(tmp);
            return;

        }
        // 递归体
        // 参考全排列
        // 判断当前行(u)中每一列是否满足条件
        for (int i = 0; i < len; i++) {
            if (!col[i] && !dg[len - u + i] && !bdg[u + i]) {
                p[u][i] = 'Q';
                col[i] = dg[len - u + i] = bdg[u + i] = true;
                dfs(u + 1);
                col[i] = dg[len - u + i] = bdg[u + i] = false;
                p[u][i] = '.';
            }
        }
    }
}
// @lc code=end
