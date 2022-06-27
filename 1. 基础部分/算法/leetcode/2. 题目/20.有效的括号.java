import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start

class Solution {
    public boolean isValid(String s) {

        // 解法一：利用Stack先进后出的规则特性
        // return extracted(s);

        // 解法二： 解法一的改良
        return extracted2(s);

    }

    /**
     * 方法改良
     * Your runtime beats 98.78 % of java submissions
     * Your memory usage beats 37.75 % of java submissions (39.3 MB)
     * 
     * @param s
     * @return
     */
    private boolean extracted2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 如果是半边的括号就放进去等待匹配
            // 放进对应的右半边括号是为了简化匹配,这样匹配的时候直接判断是不是相等就好了,节省时间
            if (c == '(')
                stack.push(')');
            if (c == '[')
                stack.push(']');
            if (c == '{')
                stack.push('}');
            // 如果是半边的括号就放进去等待匹配

            if (c == ')' || c == ']' || c == '}') {
                // 右括号放进去就开始匹配 一旦匹配失败就失败喽
                // stack.isEmpty()的时候加入右括号,肯定不能自己匹配(左边什么都没有),就失败了
                if (stack.isEmpty() || c != stack.pop())
                    return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 
     * Your runtime beats 98.78 % of java submissions
     * Your memory usage beats 18.75 % of java submissions (39.5 MB)
     * 
     * @param s
     * @return
     */
    private boolean extracted(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            // 将所有的括号左边放入到stack中
            if (tempChar == '(' || tempChar == '{' || tempChar == '[') {
                stack.push(tempChar);
            } else {
                // 从stack中抽取元素，对括号进行配对
                if (!stack.isEmpty()) {
                    char stackChar = stack.pop();
                    if (tempChar == ')') {
                        tempChar = '(';
                    } else if (tempChar == '}') {
                        tempChar = '{';
                    } else if (tempChar == ']') {
                        tempChar = '[';
                        // 特性情况直接返回false
                    } else {
                        return false;
                    }
                    // 如果 字符不配对，直接返回false
                    if (tempChar != stackChar) {
                        return false;
                    }
                    // 如果是括号的右侧，那么直接返回false
                } else {
                    return false;
                }
            }
        }
        // 最终判断stack中是否存在未配对的扩号
        return stack.isEmpty();
    }
}
// @lc code=end
