import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1557 lang=java
 *
 * [1557] 可以到达所有点的最少点数目
 */

// @lc code=start
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // 哈希去重的一种应用
        return extracted(edges);
    }

    /**
     * 66/66 cases passed (38 ms)
     * Your runtime beats 7.02 % of java submissions
     * Your memory usage beats 25.49 % of java submissions (86 MB)
     * 
     * @param edges
     * @return
     */
    private List<Integer> extracted(List<List<Integer>> edges) {
        Set<Integer> fromSet = new HashSet<>();
        Set<Integer> toSet = new HashSet<>();
        for (List<Integer> list : edges) {
            fromSet.add(list.get(0));
            toSet.add(list.get(1));
        }

        List<Integer> ans = new ArrayList<>();
        ans.addAll(fromSet);
        for (int i = 0; i < ans.size(); i++) {
            if (toSet.contains(ans.get(i))) {
                fromSet.remove(ans.get(i));
            }
        }
        ans.clear();
        ans.addAll(fromSet);
        return ans;
    }
}
// @lc code=end
