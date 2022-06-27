import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1833 lang=java
 *
 * [1833] 雪糕的最大数量
 */

// @lc code=start
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // 排序+贪心
        return extracted(costs, coins);

        // 堆
        // return extracted2(costs, coins);
    }

    /**
     * Your runtime beats 6.89 % of java submissions
     * Your memory usage beats 5.24 % of java submissions (59.9 MB)
     * 
     * @param costs
     * @param coins
     * @return
     */
    private int extracted2(int[] costs, int coins) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int len = costs.length;
        for (int i = 0; i < len; i++) {
            queue.offer(costs[i]);
        }

        int ans = 0;
        while (!queue.isEmpty() && coins >= queue.peek()) {
            int val = queue.poll();
            coins -= val;
            ans++;
        }
        return ans;
    }

    /**
     * Your runtime beats 16.39 % of java submissions
     * Your memory usage beats 76.06 % of java submissions (54.9 MB)
     * 
     * @param costs
     * @param coins
     * @return
     */
    private int extracted(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        int len = costs.length;
        for (int i = 0; i < len; i++) {
            int val = costs[i];
            if (val <= coins) {
                ans++;
                coins -= val;
            } else {
                break;
            }
        }
        return ans;
    }
}
// @lc code=end
