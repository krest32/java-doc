import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=825 lang=java
 *
 * [825] 适龄的朋友
 */

// @lc code=start
class Solution {
    public int numFriendRequests(int[] ages) {
        // 排序+双指针
        return extracted(ages);
    }

    /**
     * Your runtime beats 36.69 % of java submissions
     * Your memory usage beats 5.01 % of java submissions (45.8 MB)
     * 
     * @param ages
     * @return
     */
    private int extracted(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int left = 0, right = 0, ans = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                left++;
            }
            while (right + 1 < n && ages[right + 1] <= age) {
                right++;
            }
            ans += right - left;
        }
        return ans;
    }
}
// @lc code=end
