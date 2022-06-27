import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1944 lang=java
 *
 * [1944] 队列中可以看到的人数
 */

// @lc code=start
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        // 逆序遍历+单调栈
        // return extracted(heights);

        // 1
        return extracted2(heights);
    }

    private int[] extracted2(int[] heights) {
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(len - 1);
        int[] res = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                stack.pop();
                res[i]++;
            }
            if (!stack.isEmpty()) {
                res[i]++;
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * Your runtime beats 19.59 % of java submissions
     * Your memory usage beats 38.51 % of java submissions (59.7 MB)
     * 
     * @param heights
     * @return
     */
    private int[] extracted(int[] heights) {
        int len = heights.length;
        int[] res = new int[len];

        Stack<Integer> stack = new Stack<>();
        stack.push(len - 1);

        for (int i = len - 2; i >= 0; i--) {
            // 当前 i能够看到所有的Stack中的元素
            // 判断能够看到的元素，同时为下一步做考虑，如果当前元素大于栈顶元素，
            // 那么，后面的元素是看不到栈顶元素的 栈内是单调递增的
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                stack.pop();
                res[i]++;
            }
            // heights[i] < heights[stack.peek() 所以只能看到peek元素
            if (!stack.isEmpty()) {
                res[i]++;
            }
            stack.push(i);
        }

        return res;
    }
}
// @lc code=end
