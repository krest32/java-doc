import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=870 lang=java
 *
 * [870] 优势洗牌
 */

// @lc code=start
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        // 队列按照降序排列
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> {
                    return b[1] - a[1];
                });
        // 将B数组的坐标和value写入到队列中
        for (int i = 0; i < nums2.length; i++) {
            queue.offer(new int[] { i, nums2[i] });
        }
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            // 田忌赛马的思想，保留最大值与B的最大值最好能够一一对应
            if (nums1[right] > arr[1]) {
                res[arr[0]] = nums1[right--];
            } else {
                res[arr[0]] = nums1[left++];
            }
        }
        return res;
    }
}
// @lc code=end
