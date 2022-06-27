import java.util.Stack;

/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 行星碰撞
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // 模拟
        // return extracted(asteroids);

        // 栈
        return extracted2(asteroids);

    }

    /**
     * Your runtime beats 39.48 % of java submissions
     * Your memory usage beats 12.71 % of java submissions (42.6 MB)
     * 
     * @param asteroids
     * @return
     */
    private int[] extracted2(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ast : asteroids) {
            collision: {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }

    /**
     * Your runtime beats 47.17 % of java submissions
     * Your memory usage beats 24.56 % of java submissions (42.4 MB)
     * 
     * @param asteroids
     * @return
     */
    private int[] extracted(int[] asteroids) {
        // 反向遍历数组元素，遇到比它大的负数就置为 0
        int len = asteroids.length;
        for (int i = len - 1; i >= 0; i--) {
            int cur = asteroids[i];
            if (cur > 0) {
                int idx = i + 1;
                // 正数向右移动
                while (idx < len && asteroids[i] != 0) {
                    int next = asteroids[idx];
                    if (next >= 0) {
                        idx++;
                    } else {
                        if (Math.abs(next) == cur) {
                            asteroids[i] = 0;
                            asteroids[idx] = 0;
                        } else if (Math.abs(next) > cur) {
                            asteroids[i] = 0;
                        } else {
                            asteroids[idx] = 0;
                            idx++;
                        }
                    }
                }
            }
        }

        int size = 0;
        for (int i = 0; i < len; i++) {
            if (asteroids[i] != 0) {
                size++;
            }
        }

        int[] ans = new int[size];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (asteroids[i] != 0) {
                ans[j] = asteroids[i];
                j++;
            }
        }
        return ans;
    }
}
// @lc code=end
