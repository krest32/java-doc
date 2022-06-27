import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(n, k, ans, new ArrayList<Integer>(), 1);
        return ans;
    }

    private void backTracking(int sum,
            int k,
            List<List<Integer>> ans,
            ArrayList<Integer> arr,
            int idx) {
        if (sum == 0 && k == arr.size()) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = idx; i <= 9; i++) {
                arr.add(i);
                backTracking(sum - i, k, ans, arr, i + 1);
                arr.remove(arr.size() - 1);

            }
        }
    }
}
// @lc code=end
