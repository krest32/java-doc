import java.util.Stack;

/*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        /**
         * 二叉树的建立也伴随着槽位数量的变化。每当遇到一个节点时：
         * 如果遇到了空节点，则要消耗一个槽位；
         * 如果遇到了非空节点，则除了消耗一个槽位外，还要再补充两个槽位。
         */

        // 栈
        // return extracted(preorder);

        // 计数
        return extracted2(preorder);
    }

    /**
     * Your runtime beats 89.45 % of java submissions
     * Your memory usage beats 60.46 % of java submissions (39.6 MB)
     * 
     * @param preorder
     * @return
     */
    private boolean extracted2(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0)
                return false;
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                slots--;
                i++;
            } else {
                while (i < n && preorder.charAt(i) != ',')
                    i++;
                slots++;
            }
        }
        return slots == 0;
    }

    private boolean extracted(String preorder) {
        int n = preorder.length();
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end
