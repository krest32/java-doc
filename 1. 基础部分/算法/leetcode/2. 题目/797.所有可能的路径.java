import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=797 lang=java
 *
 * [797] 所有可能的路径
 */

// @lc code=start
class Solution {
    int[][] g;
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        n = g.length;
        cur.add(0);
        dfs(0);
        return ans;
    }

    private void dfs(int index) {
        if(index == n-1){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int next : g[index]){
            cur.add(next);
            dfs(next);
            cur.remove(cur.size()-1);
        }
    }
}
// @lc code=end
