import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=2248 lang=java
 *
 * [2248] 多个数组求交集
 */

// @lc code=start
class Solution {
    public List<Integer> intersection(int[][] nums) {
        // 哈希去重，List 排序
        return extracted(nums);
    }

    /**
     * 151/151 cases passed (4 ms)
     * Your runtime beats 60.88 % of java submissions
     * Your memory usage beats 15.43 % of java submissions (42.2 MB)
     * 
     * @param nums
     * @return
     */
    private List<Integer> extracted(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int rows = nums.length;
        for (int i = 0; i < nums[0].length; i++) {
            set.add(nums[0][i]);
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (set.contains(nums[i][j])) {
                    ans.add(nums[i][j]);
                }
            }
            set.clear();
            set.addAll(ans);
            if (i != rows - 1) {
                ans.clear();
            }
        }
        if (rows == 1) {
            ans.addAll(set);
        }

        ans.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return ans;
    }
}
// @lc code=end
