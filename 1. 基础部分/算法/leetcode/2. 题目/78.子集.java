import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(nums, ans, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void backTracking(int[] nums,
            List<List<Integer>> ans,
            ArrayList<Integer> arr,
            int key) {
        ans.add(new ArrayList<>(arr));
        for (int i = key; i < nums.length; i++) {
            arr.add(nums[i]);
            backTracking(nums, ans, arr, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}
// @lc code=end
