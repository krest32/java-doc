import java.util.Stack;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {

    Stack<Integer> instack, outStack;

    public MyQueue() {
        instack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        instack.push(x);
    }

    /**
     * 栈是先进后出，队列是先进先出，
     * 所以需要两个栈来完成队列功能，
     * 一个作为入栈，另一个作为出栈，
     * 当元素入栈后，再转移到出栈中
     * 
     * @return
     */
    public int pop() {
        if (outStack.isEmpty()) {
            while (!instack.isEmpty()) {
                outStack.push(instack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!instack.isEmpty()) {
                outStack.push(instack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return instack.isEmpty() && outStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end
