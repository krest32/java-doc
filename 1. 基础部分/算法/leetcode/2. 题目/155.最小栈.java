
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {

    Stack<Integer> xStack;
    Stack<Integer> minStack;
    
    public MinStack() {
        xStack = new Stack<>();
        minStack = new Stack<>();
        // 初始化，在栈中放入最大整数
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        xStack.push(val);
        // 通过比较永远记录栈中最小的元素
        minStack.push(Math.min(minStack.peek(), val));
    }
    
    public void pop() {
        // 保证放入的是栈中的最小值
        xStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

