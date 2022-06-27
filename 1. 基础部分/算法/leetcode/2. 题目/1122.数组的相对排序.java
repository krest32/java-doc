/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 模拟 计数排序
        return extracted(arr1, arr2);
    }

    private int[] extracted(int[] arr1, int[] arr2) {
        int upper = 0;
        // 获取arr1中的最大值
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        // 获取每个数字的出现频率
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            frequency[x]++;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        // 向结果数组中添加元素
        for (int x : arr2) {
            // 追加arr1中每个数字出现的次数
            for (int i = 0; i < frequency[x]; i++) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }

        // 追加arr2 中 arr1 没有出现的元素
        for (int x = 0; x <= upper; x++) {
            for (int i = 0; i < frequency[x]; i++) {
                ans[index++] = x;
            }
        }
        return ans;
    }
}
// @lc code=end
