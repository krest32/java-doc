import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        // 回溯
        // return extracted(nums);

        // 1
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        backTrackingTest(nums, ans, vis, new ArrayList<Integer>());
        return ans;
    }

    private void backTrackingTest(int[] nums,
            List<List<Integer>> ans,
            boolean[] vis,
            ArrayList<Integer> arr) {
        if (arr.size() == nums.length) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!vis[i]) {
                    vis[i] = true;
                    arr.add(nums[i]);
                    backTrackingTest(nums, ans, vis, arr);
                    arr.remove(arr.size() - 1);
                    vis[i] = false;
                }
            }
        }
    }

    private List<List<Integer>> extracted(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        backTracking(nums, vis, ans, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void backTracking(int[] nums,
            boolean[] vis,
            List<List<Integer>> ans,
            ArrayList<Integer> arr,
            int key) {
        if (arr.size() == nums.length) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = key; i < nums.length; i++) {
                // 剪枝，需要将使用过的数字排除在外
                if (vis[i]) {
                    continue;
                }
                vis[i] = true;
                arr.add(nums[i]);
                backTracking(nums, vis, ans, arr, 0);
                arr.remove(arr.size() - 1);
                vis[i] = false;
            }
        }
    }
}
// @lc code=end
