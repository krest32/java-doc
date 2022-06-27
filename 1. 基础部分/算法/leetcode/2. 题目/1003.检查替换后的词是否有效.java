import java.util.Stack;

import javafx.geometry.Side;

/*
 * @lc app=leetcode.cn id=1003 lang=java
 *
 * [1003] 检查替换后的词是否有效
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                stack.push(ch);
            } else if (ch == 'b') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.push(ch);
                }
            } else {
                if (stack.size() < 2) {
                    return false;
                }
                char first = stack.pop();
                char second = stack.pop();
                if (first != 'b' || second != 'a')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end
