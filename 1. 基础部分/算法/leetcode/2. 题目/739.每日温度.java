import java.util.Stack;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 使用栈
        // return extracted(temperatures);

        // 暴力
        return extracted2(temperatures);
    }

    /**
     * Your runtime beats 10.26 % of java submissions
     * Your memory usage beats 74.74 % of java submissions (50.8 MB)
     * 
     * @param temperatures
     * @return
     */
    private int[] extracted2(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int cur = temperatures[i];
            int idx = 1;
            for (int j = i + 1; j < len; j++) {
                int next = temperatures[j];
                if (next > cur) {
                    ans[i] = idx;
                    break;
                }
                idx++;
            }
        }
        return ans;
    }

    private int[] extracted(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
// @lc code=end
