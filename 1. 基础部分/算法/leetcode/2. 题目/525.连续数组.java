import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=525 lang=java
 *
 * [525] 连续数组
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        // 暴力 -> 超时
        // return extracted(nums);

        // 暴力优化--> 超时
        // return extracted2(nums);

        // 老是超时说明了思维的方式不对
        // 由于0 和 1 的数量相同等价于1 的数量减去 0 的数量等于 0，
        // 我们可以将数组中的 0 视作−1，则原问题转换成「求最长的连续子数组，
        // 其元素和为 0
        // 一次遍历+哈希
        return extracted3(nums);

    }

    /**
     * Your runtime beats 78.36 % of java submissions
     * Your memory usage beats 8.87 % of java submissions (50.5 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted3(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }

    /**
     * 40/564 cases passed (N/A)
     */
    private int extracted2(int[] nums) {
        int len = nums.length;
        // 分别记录到达每个位置的0，1的个数
        int[] dp0 = new int[len + 1];
        int[] dp1 = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            int cur = nums[i - 1];
            // 添加 0-i 位置共有多少 0
            if (cur == 0) {
                dp0[i] = dp0[i - 1] + 1;
            } else {
                dp0[i] = dp0[i - 1];
            }
            // 记录 0-i 位置共有多少 1
            if (cur == 1) {
                dp1[i] = dp1[i - 1] + 1;
            } else {
                dp1[i] = dp1[i - 1];
            }
        }

        int ans = 0;
        for (int i = 1; i <= len; i++) {
            int j = 1;
            while (j < i && i - j > ans) {
                int zeros = dp0[i] - dp0[j - 1];
                int ones = dp1[i] - dp1[j - 1];
                if (ones == zeros) {
                    ans = Math.max(ans, i - j + 1);
                }
                j++;
            }
        }
        return ans;
    }

    /**
     * 26/564 超时
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        int len = nums.length;
        // 分别记录到达每个位置的0，1的个数
        int[] dp0 = new int[len + 1];
        int[] dp1 = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            int cur = nums[i - 1];
            // 添加 0-i 位置共有多少 0
            if (cur == 0) {
                dp0[i] = dp0[i - 1] + 1;
            } else {
                dp0[i] = dp0[i - 1];
            }
            // 记录 0-i 位置共有多少 1
            if (cur == 1) {
                dp1[i] = dp1[i - 1] + 1;
            } else {
                dp1[i] = dp1[i - 1];
            }
        }

        // 待改进
        int ans = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                int zeros = dp0[j] - dp0[i - 1];
                int ones = dp1[j] - dp1[i - 1];
                System.out.println(zeros + " " + ones);
                if (ones == zeros) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}
// @lc code=end
