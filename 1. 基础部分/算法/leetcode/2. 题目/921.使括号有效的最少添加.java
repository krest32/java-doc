import java.util.Stack;

/*
 * @lc app=leetcode.cn id=921 lang=java
 *
 * [921] 使括号有效的最少添加
 */

// @lc code=start
class Solution {
    public int minAddToMakeValid(String s) {
        // 使用 栈
        // return extracted(s);

        // 优化栈 -> 使用计数法代替栈
        return extracted2(s);
    }

    /**
     * 115/115 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 5.01 % of java submissions (39.8 MB)
     * 
     * @param s
     * @return
     */
    private int extracted2(String s) {
        int leftCnt = 0;
        int rightCnt = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                leftCnt++;
            } else {
                if (leftCnt == 0) {
                    rightCnt++;
                } else {
                    leftCnt--;
                }
            }
        }
        return leftCnt + rightCnt;
    }

    /**
     * 115/115 cases passed (2 ms)
     * Your runtime beats 11.05 % of java submissions
     * Your memory usage beats 5.01 % of java submissions (39.8 MB)
     * 
     * @param s
     * @return
     */
    private int extracted(String s) {
        Stack<Character> leftStack = new Stack<>();
        int ans = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                leftStack.push(ch);
            } else {
                if (leftStack.isEmpty()) {
                    ans++;
                } else {
                    leftStack.pop();
                }
            }
        }
        return leftStack.size() + ans;
    }
}
// @lc code=end
