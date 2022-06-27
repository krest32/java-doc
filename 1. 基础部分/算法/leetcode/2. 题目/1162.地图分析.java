import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1162 lang=java
 *
 * [1162] 地图分析
 */

// @lc code=start
class Solution {
    public int maxDistance(int[][] grid) {
        // 单源BFS超时
        // return extracted(grid);

        // 多源BFS
        return extracted2(grid);
    }

    /**
     * Your runtime beats 90.74 % of java submissions
     * Your memory usage beats 73.06 % of java submissions (42.1 MB)
     * 
     * @param grid
     * @return
     */
    private int extracted2(int[][] grid) {
        int n = grid.length;

        Deque<int[]> dueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 将元素加入到队列中
                    dueue.addLast(new int[] { i, j });
                    // 避免当前节点多次被调用
                    grid[i][j] = -1;
                }
            }
        }
        int ans = -1;
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!dueue.isEmpty()) {
            int[] poll = dueue.pollFirst();
            int dx = poll[0], dy = poll[1];
            int step = Math.max(grid[dx][dy], 0);
            for (int[] di : dirs) {
                // 定义四个方向
                int nx = dx + di[0], ny = dy + di[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if (grid[nx][ny] != 0)
                    continue;
                dueue.addLast(new int[] { nx, ny });
                grid[nx][ny] = step + 1;
                ans = Math.max(ans, step + 1);
            }
        }
        return ans;
    }

    /**
     * 单源BFS超时
     */
    private int extracted(int[][] grid) {
        int rows = grid.length;
        int colums = grid[0].length;
        int ret = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (grid[i][j] == 0) {
                    int num = check(grid, i, j);
                    ret = Math.max(ret, num);
                }
            }
        }
        return ret;
    }

    private int check(int[][] grid,
            int x,
            int y) {
        int n = grid.length;
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        Deque<int[]> deque = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        deque.addLast(new int[] { x, y });
        map.put(x * n + y, 0);
        while (!deque.isEmpty()) {
            int[] poll = deque.pollFirst();
            int dx = poll[0], dy = poll[1];
            int step = map.get(dx * n + dy);
            if (grid[dx][dy] == 1)
                return step;
            for (int[] di : dirs) {
                int nx = dx + di[0], ny = dy + di[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                int key = nx * n + ny;
                if (map.containsKey(key))
                    continue;
                deque.addLast(new int[] { nx, ny });
                map.put(key, step + 1);
            }
        }
        return -1;
    }
}
// @lc code=end
