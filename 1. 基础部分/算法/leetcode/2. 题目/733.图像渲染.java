import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=733 lang=java
 *
 * [733] 图像渲染
 */

// @lc code=start
class Solution {
    // 定义四个方向
    int[] dx = { 1, 0, 0, -1 };
    int[] dy = { 0, 1, -1, 0 };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 广度优先搜索
        // return extracted(image, sr, sc, newColor);

        // 深度优先搜索 --> 最优解
        return extracted2(image, sr, sc, newColor);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 39.61 % of java submissions (42 MB)
     */
    private int[][] extracted2(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor != newColor) {
            dfs(image, sr, sc, currColor, newColor);
        }
        return image;
    }

    public void dfs(int[][] image, int x, int y, int color, int newColor) {
        if (image[x][y] == color) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, color, newColor);
                }
            }
        }
    }

    /**
     * Your runtime beats 44.46 % of java submissions
     * Your memory usage beats 41.35 % of java submissions (42 MB)
     * 
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    private int[][] extracted(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] { sr, sc });
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m
                        && image[mx][my] == currColor) {
                    queue.offer(new int[] { mx, my });
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }
}
// @lc code=end
