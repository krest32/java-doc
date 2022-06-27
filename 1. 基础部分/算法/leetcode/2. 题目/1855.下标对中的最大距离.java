/*
 * @lc app=leetcode.cn id=1855 lang=java
 *
 * [1855] 下标对中的最大距离
 */

// @lc code=start
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        // 超时
        // return extracted(nums1, nums2);

        // 双指针
        return extracted2(nums1, nums2);

    }

    /**
     * 32/32 cases passed (3 ms)
     * Your runtime beats 79.83 % of java submissions
     * Your memory usage beats 53.74 % of java submissions (54.2 MB)
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    private int extracted2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int res = 0;
        for (int j = 0; j < m; j++) {
            // 因为为非递增数组,所以如果要nums1[i]<nums[j]的话,
            // 就得在nums1[i]>nums2[j]的情况下,i++,直到nums1[i]<nums[j]为止
            while (i < n && nums1[i] > nums2[j]) {
                i++;
            }
            if (i < n) {
                res = Math.max(res, j - i);
            }
        }
        return res;
    }

    private int extracted(int[] nums1, int[] nums2) {
        int curPos = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len1; i++) {
            for (int j = len2 - 1; j > i; j--) {
                //
                if (curPos > j - i) {
                    break;
                }
                if (nums2[j] >= nums1[i]) {
                    curPos = Math.max(curPos, j - i);
                }
            }
        }
        return curPos;
    }
}
// @lc code=end
