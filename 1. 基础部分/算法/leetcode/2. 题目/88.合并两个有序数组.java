import java.util.Arrays;

import javax.sound.midi.Soundbank;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 方法一 双指针
        extracted(nums1, m, nums2, n);

        // 方法二 程序Api -> 虽然简单，但是效率低
        // extracted2(nums1, m, nums2, n);
    }

    /**
     * 程序Api -> Dual-Pivot快排
     * Your runtime beats 18.2 % of java submissions
     * Your memory usage beats 31.51 % of java submissions (41.2 MB)
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private void extracted2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 双指针
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 42.04 % of java submissions (41.1 MB)
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private void extracted(int[] nums1, int m, int[] nums2, int n) {
        // 定义初始变量
        int len1 = m;
        int len2 = n;
        int[] sorted = new int[len1 + len2];
        // 定义两个数组的操作指针
        int index1 = 0;
        int index2 = 0;
        while (index1 < len1 || index2 < len2) {
            int temp = 0;
            // 对于数组元素进行判空操作
            if (index1 >= len1) {
                temp = nums2[index2++];
            } else if (index2 >= len2) {
                temp = nums1[index1++];

                // 比较两个数组中元素的大小
            } else if (nums1[index1] <= nums2[index2]) {
                temp = nums1[index1++];
            } else {
                temp = nums2[index2++];
            }

            // 对于排序的数组进行赋值
            sorted[index1 + index2 - 1] = temp;
        }

        // 对结果赋值
        for (int i = 0; i < len1 + len2; i++) {
            nums1[i] = sorted[i];
        }
    }
}
// @lc code=end
