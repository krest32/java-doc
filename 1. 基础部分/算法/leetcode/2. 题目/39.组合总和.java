import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // 回溯
        return extracted(candidates, target);

    }

    private List<List<Integer>> extracted(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res,
            ArrayList<Integer> temp, int idx) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = idx; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    temp.add(candidates[i]);
                    // 此处传入i,代表仅使用数组后面的元素
                    dfs(candidates, target - candidates[i], res, temp, i);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
// @lc code=end
