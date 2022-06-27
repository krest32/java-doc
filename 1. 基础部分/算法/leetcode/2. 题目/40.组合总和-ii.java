import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(candidates, target, ans, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void backTracking(int[] candidates,
            int target,
            List<List<Integer>> ans,
            ArrayList<Integer> arr,
            int key) {
        if (target == 0) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = key; i < candidates.length; i++) {
                // 剪枝，如果当前数字与上一个数字相同，去掉其他匹配项
                if (i != key && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                if (candidates[i] <= target) {
                    arr.add(candidates[i]);
                    backTracking(candidates, target - candidates[i],
                            ans, arr, i + 1);
                    arr.remove(arr.size() - 1);
                }
            }
        }

    }
}
// @lc code=end
