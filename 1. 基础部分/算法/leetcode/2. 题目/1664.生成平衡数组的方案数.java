import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1664 lang=java
 *
 * [1664] 生成平衡数组的方案数
 */

// @lc code=start
class Solution {
    public int waysToMakeFair(int[] nums) {
        // 暴力
        // return extracted(nums);

        // 前缀和
        return extracted2(nums);
    }

    /**
     * 105/105 cases passed (6 ms)
     * Your runtime beats 49.63 % of java submissions
     * Your memory usage beats 37.78 % of java submissions (51.7 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted2(int[] nums) {
        int n = nums.length;
        int[] sumRights = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            if (i + 2 < n)
                sumRights[i] += sumRights[i + 2];
            sumRights[i] += nums[i];
        }

        int a = 0;// 偶数位
        int b = 0;// 奇数位
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (a + sumRights[i + 1] == b + sumRights[i + 2])
                    ++ans;
                a += nums[i];
            } else {
                if (a + sumRights[i + 2] == b + sumRights[i + 1])
                    ++ans;
                b += nums[i];
            }
        }
        return ans;
    }

    /**
     * Time Limit Exceeded
     * 77/105 cases passed (N/A)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int cnt = 0;
        int idx = 0;
        while (idx < list.size()) {
            int cur = list.get(idx);
            list.remove(idx);
            if (isFair(list)) {
                cnt++;
            }
            list.add(idx, cur);
            idx++;
        }
        return cnt;
    }

    public boolean isFair(List<Integer> list) {
        int idd = 0;
        int odd = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                odd += list.get(i);
            } else {
                idd += list.get(i);
            }
        }
        return idd == odd;
    }
}
// @lc code=end
