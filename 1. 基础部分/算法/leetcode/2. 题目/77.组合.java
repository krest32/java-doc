import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(n, k, ans, new ArrayList<Integer>(), 1);
        return ans;
    }

    private void backTracking(int n,
            int k,
            List<List<Integer>> ans,
            ArrayList<Integer> arr,
            int key) {
        if (arr.size() == k) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = key; i <= n; i++) {
                arr.add(i);
                backTracking(n, k, ans, arr, i + 1);
                arr.remove(arr.size() - 1);
            }
        }
    }
}
// @lc code=end
