import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1654 lang=java
 *
 * [1654] 到家的最少跳跃次数
 */

// @lc code=start
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        // BFS －＞ 但是性能一般
        // return extracted(forbidden, a, b, x);

        // 1
        return test(forbidden, a, b, x);

    }

    private int test(int[] forbidden, int a, int b, int x) {
        final int Limit = 8000;
        boolean[][] vis = new boolean[Limit + 1][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        Set<Integer> set = new HashSet<>();
        for (int num : forbidden)
            set.add(num);
        int times = -1;
        while (!queue.isEmpty()) {
            times++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int dis = cur[0];
                int bakTimes = cur[1];
                if (dis == x)
                    return times;
                if (vis[dis][bakTimes])
                    continue;
                vis[dis][bakTimes] = true;
                if (dis + a <= Limit && !set.contains(dis + a))
                    queue.offer(new int[] { dis + a, 0 });
                if (dis - b >= 0 && bakTimes < 1 && !set.contains(dis - b))
                    queue.offer(new int[] { dis - b, bakTimes + 1 });
            }
        }
        return -1;
    }

    /**
     * Your runtime beats 18.75 % of java submissions
     * Your memory usage beats 47.62 % of java submissions (41.5 MB)
     * 
     * @param forbidden
     * @param a
     * @param b
     * @param x
     * @return
     */
    private int extracted(int[] forbidden, int a, int b, int x) {
        // 先判断能否调到家
        // 它可以 往前 跳恰好 a个位置（即往右跳）。
        // 它可以 往后跳恰好 b个位置（即往左跳）。
        // 它不能 连续 往后跳 2 次。
        // 它不能跳到任何forbidden数组中的位置。
        // 跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。

        final int LIMIT = 8000;
        boolean[][] visited = new boolean[8001][2];
        Set<Integer> forbid = new HashSet<>(forbidden.length);
        for (int i : forbidden)
            forbid.add(i);
        Queue<int[]> q = new LinkedList<>(); // [ 当前位置, 向后跳次数 ]
        q.offer(new int[] { 0, 0 });
        int layer = -1;
        while (!q.isEmpty()) {
            int qs = q.size();
            layer++;
            for (int i = 0; i < qs; i++) {
                int[] p = q.poll();
                int cur = p[0];
                int backwardCount = p[1];
                if (cur == x)
                    return layer;
                if (visited[cur][backwardCount])
                    continue;
                visited[cur][backwardCount] = true;

                if (cur + a <= LIMIT && !forbid.contains(cur + a)) {
                    q.offer(new int[] { cur + a, 0 });
                }
                if (cur - b >= 0 && backwardCount < 1 && !forbid.contains(cur - b)) {
                    q.offer(new int[] { cur - b, backwardCount + 1 });
                }
            }
        }
        return -1;
    }
}
// @lc code=end
