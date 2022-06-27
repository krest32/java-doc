
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        // 解法一： Set 去重，性能有些低
        // return extracted(nums);

        // 解法二： Set 标记元素
        return extracted1(nums);

        // 程序去重 --> 最优解
        // return extracted2(nums);

    }

    private List<List<Integer>> extracted1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking2(ans, nums, Integer.MIN_VALUE, 0, new ArrayList<Integer>());
        return ans;
    }

    private void backTracking2(List<List<Integer>> ans,
            int[] nums,
            int curNbr,
            int key,
            ArrayList<Integer> temp) {

        if (temp.size() >= 2) {
            ans.add(new ArrayList<>(temp));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = key; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (nums[i] >= curNbr) {
                temp.add(nums[i]);
                backTracking2(ans, nums, nums[i], i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 61.39 % of java submissions (46.7 MB)
     * 
     * @param nums
     * @return
     */
    private List<List<Integer>> extracted2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(ans, temp, 0, Integer.MIN_VALUE, nums);
        return ans;
    }

    /**
     * cur 表示当前数组应该有的长度
     * last 表示递增的数字
     */
    void dfs(List<List<Integer>> ans, List<Integer> temp, int cur, int last, int[] nums) {
        if (cur == nums.length) {
            // 如果list.size > 2,符合要求
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(ans, temp, cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        // 去掉重复的元素
        if (nums[cur] != last) {
            dfs(ans, temp, cur + 1, last, nums);
        }
    }

    /**
     * Your runtime beats 8.63 % of java submissions
     * Your memory usage beats 11.56 % of java submissions (48.9 MB)
     * 
     * @param nums
     * @return
     */
    private List<List<Integer>> extracted(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        backTracking(nums, ans, temp, 0, Integer.MIN_VALUE);
        return new ArrayList<>(ans);
    }

    private void backTracking(int[] nums,
            Set<List<Integer>> ans,
            List<Integer> temp,
            int key,
            int curNbr) {
        if (temp.size() >= 2) {
            ans.add(new ArrayList<>(temp));
        }
        for (int i = key; i < nums.length; i++) {
            if (nums[i] >= curNbr) {
                temp.add(nums[i]);
                backTracking(nums, ans, temp, i + 1, nums[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
// @lc code=end
