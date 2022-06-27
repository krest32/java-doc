import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1046 lang=java
 *
 * [1046] 最后一块石头的重量
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        //模拟 元素降序排列
        return extracted(stones);
    }

    private int extracted(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            if (a > b) {
                // 想减，得到差值
                queue.offer(a - b);
            }
        }
        // 返回最后一个值，或者0
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
// @lc code=end
