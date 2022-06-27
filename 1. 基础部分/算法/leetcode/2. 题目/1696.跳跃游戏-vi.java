import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1696 lang=java
 *
 * [1696] 跳跃游戏 VI
 */

// @lc code=start
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(nums[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            // 跳跃的距离在数组中
            /**
             * 由于我们在每次计算dp[i]时，需要遍历i的前k个元素得到其中最大的dp[i-k]，
             * 因此我们可以使用一个严格单调递减队列存储这前k个元素的dp[i]，
             * 每次在计算dp[i]时直接用单调递减队列的第一个元素值计算即可，
             * dp[i] = nums[i] + dp[queue.getFirst()]。
             */
            if (i + k < n - 1) {
                if (deque.peekFirst() == nums[i + k + 1]) {
                    deque.pollFirst();
                }
            }
            nums[i] = nums[i] + deque.peekFirst();
            // 单调递减队列
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        return nums[0];
    }
}
// @lc code=end
