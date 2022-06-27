import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1559 lang=java
 *
 * [1559] 二维网格图中探测环
 */

// @lc code=start
class Solution {
    // 定义四个方向
    int[][] direcs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public boolean containsCycle(char[][] grid) {
        // 答案中使用了并集查
        // 有环代表set集合起码>=3
        int rows = grid.length;
        int colums = grid[0].length;
        boolean[][] vis = new boolean[rows][colums];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                char ch = grid[i][j];
                Set<int[]> set = new HashSet<>();
                set.add(new int[] { i, j });
                if (!vis[i][j] && check(grid, i, j, vis, set, ch)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 判断是否存在环
    private boolean check(char[][] grid, int i, int j, boolean[][] vis, Set<int[]> set, char ch) {
        int[] arr = { i, j };
        if (set.size() > 3 && check(set, arr)) {
            return true;
        } else {
            set.add(arr);
        }
        int rows = grid.length;
        int colums = grid[0].length;
        for (int[] direc : direcs) {
            int newi = i + direc[0];
            int newj = j + direc[1];
            if (newi >= 0 && newj >= 0 && newi < rows && newj < colums
                    && grid[newi][newj] == ch && !vis[newi][newj]) {
                vis[newi][newj] = true;
                set.add(new int[] { newi, newj });
                if (check(grid, newi, newj, vis, set, ch)) {
                    return true;
                }
                set.remove(set.size()-1);
            }
        }
        return false;
    }

    private boolean check(Set<int[]> set, int[] arr) {
        Iterator<int[]> iterator = set.iterator();
        while (iterator.hasNext()) {
            int[] next = iterator.next();
            if (Arrays.equals(next, arr)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
