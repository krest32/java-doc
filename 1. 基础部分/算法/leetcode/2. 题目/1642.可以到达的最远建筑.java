
import java.util.PriorityQueue;
import java.util.Queue;


/*
 * @lc app=leetcode.cn id=1642 lang=java
 *
 * [1642] 可以到达的最远建筑
 */

// @lc code=start
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // 该队列每次回从中取出最小的数字
        Queue<Integer> queue = new PriorityQueue<>();
        int n = heights.length, sum = 0;
        for(int i=1; i<n; i++){
            int diff = heights[i] - heights[i-1];
            // 如果存在高度差
            if(diff>0){
                queue.offer(diff);

                // 判断梯子能够跨越的建筑物的个数
                // 优先使用梯子，梯子不够时依次选出最先的差值改用砖头
                if(queue.size() > ladders){
                    sum += queue.poll();
                }

                // 判断最小的差值和sum中需要使用到的砖的个数
                if(sum > bricks){
                    return i-1;
                }
            }
        }
        return n-1;
    }
}
// @lc code=end

