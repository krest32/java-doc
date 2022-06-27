import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        backTracking(nums, ans, vis, new ArrayList<Integer>(), 0);
        return ans;

    }

    private void backTracking(int[] nums,
            List<List<Integer>> ans,
            boolean[] vis,
            ArrayList<Integer> arr,
            int key) {
        // 递归终止条件
        if (arr.size() == nums.length) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 剪枝： 去掉自身以及一些用过的元素
                if (vis[i]) {
                    continue;
                }
                // 剪枝：保证相同的数字都相邻，然后每次填入的数一定是这个数
                // 所在重复数集合中「从左往右第一个未被填过的数字」
                if (i != key && nums[i] == nums[i - 1] && !vis[i - 1]) {
                    continue;
                }
                vis[i] = true;
                arr.add(nums[i]);
                backTracking(nums, ans, vis, arr, 0);
                arr.remove(arr.size() - 1);
                vis[i] = false;
            }
        }
    }
}
// @lc code=end
