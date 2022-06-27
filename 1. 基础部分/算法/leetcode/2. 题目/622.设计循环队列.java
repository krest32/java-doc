/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */

// @lc code=start
class MyCircularQueue {
    int[] queue;
    int headIndex;
    int count;
    int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
    }
    
    // 存储新元素
    public boolean enQueue(int value) {
        if(this.count == this.capacity){
            return false;
        }
        // 简易计算hash值
        this.queue[(this.headIndex + this.count) % this.capacity] = value;
        this.count += 1;
        return true;
    }
    
    // 删除一个元素
    public boolean deQueue() {
        if(this.count == 0){
            return false;
        }
        // 头指针向后移动一个位置
        this.headIndex = (this.headIndex+1) % this.capacity;
        this.count -= 1;
        return true;
    }
    // 从队首获取元素。如果队列为空，返回 -1
    public int Front() {
        if(this.count == 0){
            return -1;
        }
        return this.queue[this.headIndex];
    }
    
    // 获取队尾元素。如果队列为空，返回 -1 
    public int Rear() {
        if(this.count == 0){
            return -1;
        }
        int tailIndex = (this.headIndex + this.count -1) % this.capacity;
        return this.queue[tailIndex];
    }
    
    public boolean isEmpty() {
        return this.count == 0;
    }
    
    public boolean isFull() {
        return this.count == this.capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

