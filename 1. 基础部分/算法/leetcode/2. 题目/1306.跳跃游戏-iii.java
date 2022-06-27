import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1306 lang=java
 *
 * [1306] 跳跃游戏 III
 */

// @lc code=start
class Solution {
    public boolean canReach(int[] arr, int start) {
        // BFS 但是效率有些低
        // return extracted(arr, start);

        // DFS 对内存更加友好，时间上提升不少
        return extracted2(arr, start);
    }

    private boolean extracted2(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        return dfs(arr, start, n, visited);
    }

    /**
     * 56/56 cases passed (2 ms)
     * Your runtime beats 99.06 % of java submissions
     * Your memory usage beats 18.91 % of java submissions (53.2 MB)
     * 
     * @param num
     * @param idx
     * @param n
     * @param visited
     * @return
     */
    public boolean dfs(int[] num, int idx, int n, boolean[] visited) {
        if (idx < 0 || idx >= num.length || visited[idx]) {
            return false;
        }
        if (num[idx] == 0) {
            return true;
        }
        int step = num[idx];
        visited[idx] = true;
        return dfs(num, idx + step, n, visited) || dfs(num, idx - step, n, visited);
    }

    /**
     * 56/56 cases passed (71 ms)
     * Your runtime beats 5.73 % of java submissions
     * Your memory usage beats 65.35 % of java submissions (48.9 MB)
     * 
     * @param arr
     * @param start
     * @return
     */
    private boolean extracted(int[] arr, int start) {
        int len = arr.length;
        // 因为只会有两个跳跃的方向，所以使用队列
        boolean[] vis = new boolean[len];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                System.out.println(cur);
                if (arr[cur] == 0) {
                    return true;
                }
                vis[cur] = true;
                // 先向左跳
                int leftJump = cur - arr[cur];
                if (leftJump >= 0 && !vis[leftJump]) {
                    queue.offer(leftJump);
                }

                // 再向右跳
                int rightJump = cur + arr[cur];
                if (rightJump < len && !vis[rightJump]) {
                    queue.offer(rightJump);
                }
            }
        }
        return false;
    }
}
// @lc code=end
