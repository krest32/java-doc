import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1443 lang=java
 *
 * [1443] 收集树上所有苹果的最少时间
 */

// @lc code=start
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // 深度优先遍历
        return extracted(n, edges, hasApple);
    }

    /**
     * 55/55 cases passed (23 ms)
     * Your runtime beats 83.13 % of java submissions
     * Your memory usage beats 56.02 % of java submissions (83.5 MB)
     * 
     * @param n
     * @param edges
     * @param hasApple
     * @return
     */
    private int extracted(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        boolean[] visited = new boolean[n];
        for (int[] v : edges) {
            int a = v[0];
            int b = v[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        return dfs(list, hasApple, visited, 0)[0];
    }

    private int[] dfs(List<List<Integer>> list, List<Boolean> hasApple, boolean[] visited, int index) {
        int res = 0;
        int nodeCount = 0;
        visited[index] = true;
        for (int dx : list.get(index)) {
            if (visited[dx])
                continue;
            int[] v = dfs(list, hasApple, visited, dx);
            if (v[1] == 0)
                res += 0;
            else {
                res += v[0] + 2;
                nodeCount += v[1];
            }
        }
        if (hasApple.get(index))
            nodeCount++;
        return new int[] { res, nodeCount };
    }

}
// @lc code=end
