/*
 * @lc app=leetcode.cn id=1775 lang=java
 *
 * [1775] 通过最少操作次数使数组的和相等
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0;
        int sum2 = 0;
        int hash1[] = new int[7];
        int hash2[] = new int[7];
        // 记录每个数字出现的次数
        for (int a : nums1) {
            sum1 += a;
            hash1[a]++;
        }
        for (int a : nums2) {
            sum2 += a;
            hash2[a]++;
        }
        // 记录改变的次数
        int res = 0;
        // 如果和相等，那么直接返回0
        if (sum1 == sum2)
            return 0;

        // 当sum1 > sum2 时，执行减操作
        if (sum1 > sum2) {
            int cha = sum1 - sum2;
            for (int i = 1; i <= 6; i++) {
                while (hash1[7 - i] != 0 && cha > 0) {
                    cha = Math.max(cha - (6 - i), 0);
                    hash1[7 - i]--;
                    res++;
                }
                while (hash2[i] != 0 && cha > 0) {
                    cha = Math.max(cha - (6 - i), 0);
                    hash2[i]--;
                    res++;
                }
                if (cha == 0) return res;
            }
            return -1;
        } else {
            int cha = sum2 - sum1;
            for (int i = 1; i <= 6; i++) {
                while (hash2[7 - i] != 0 && cha > 0) {
                    cha = Math.max(cha - (6 - i), 0);
                    hash2[7 - i]--;
                    res++;
                }
                while (hash1[i] != 0 && cha > 0) {
                    cha = Math.max(cha - (6 - i), 0);
                    hash1[i]--;
                    res++;
                }
                if (cha == 0)
                    return res;
            }
            return -1;
        }
    }
}
// @lc code=end
