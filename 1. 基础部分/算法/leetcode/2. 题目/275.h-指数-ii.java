/*
 * @lc app=leetcode.cn id=275 lang=java
 *
 * [275] H 指数 II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        // 二分查找的灵活应用
        return extracted(citations);
    }

    private int extracted(int[] citations) {
        int len = citations.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 有 n−mid 篇论文被引用了至少citations[mid] 次
            if (citations[mid] >= len - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return len - left;
    }
}
// @lc code=end
