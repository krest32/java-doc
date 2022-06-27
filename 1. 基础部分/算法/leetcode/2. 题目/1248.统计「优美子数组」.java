/*
 * @lc app=leetcode.cn id=1248 lang=java
 *
 * [1248] 统计「优美子数组」
 */

// @lc code=start
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // 滑动窗口
        // return extracted(nums, k);

        // 1
        return test(nums, k);
    }

    private int test(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int oddCnt = 0;
        int res = 0;
        int len = nums.length;
        while (right < len) {
            if (nums[right++] % 2 == 1) {
                oddCnt++;
            }
            if (oddCnt == k) {
                int temp = right;
                while (right < len && nums[right] % 2 == 0) {
                    right++;
                }
                int evenRight = right - temp;
                int evenleft = 0;
                while (nums[left] % 2 == 0) {
                    left++;
                    evenleft++;
                }
                res += (evenRight + 1) * (evenleft + 1);
                left++;
                oddCnt--;
            }
        }
        return res;
    }

    /**
     * Your runtime beats 57.72 % of java submissions
     * Your memory usage beats 59.19 % of java submissions (48.8 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    private int extracted(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int oddCnt = 0;
        int res = 0;
        int len = nums.length;
        while (right < len) {
            if ((nums[right++] % 2) == 1) {
                // 记录窗口内奇数的个数
                oddCnt++;
            }

            if (oddCnt == k) {
                int tmp = right;
                // 找到下一个戒指奇数的位置
                while (right < len && (nums[right] % 2) == 0) {
                    right++;
                }
                int rightEvenCnt = right - tmp;
                // leftEvenCnt 即为第 1 个奇数左边的偶数的个数
                int leftEvenCnt = 0;
                while ((nums[left] % 2) == 0) {
                    leftEvenCnt++;
                    left++;
                }

                res += (leftEvenCnt + 1) * (rightEvenCnt + 1);
                // 此时 left 指向的是第 1 个奇数，因为该区间已经统计完了，因此 left 右移一位，oddCnt--
                left++;
                oddCnt--;
            }
        }
        return res;
    }
}
// @lc code=end
