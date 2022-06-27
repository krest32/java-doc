/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[(n+1)/2];
        int index = -1;
        for(int i=0; i<n; i++){
            String token = tokens[i];
            switch(token){
                case "+":
                    index--;
                    stack[index] += stack[index+1];
                    break; 
                case "-":
                    index--;
                    stack[index] -= stack[index+1];
                    break; 
                case "*":
                    index--;
                    stack[index] *= stack[index+1];
                    break; 
                case "/":
                    index--;
                    stack[index] /= stack[index+1];
                    break; 
                default:
                    // 将元素放入到
                    index++;
                    stack[index] = Integer.parseInt(token);
            }
        }
        return stack[index];
    }
}
// @lc code=end
