import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=2216 lang=java
 *
 * [2216] 美化数组的最少删除数
 */

// @lc code=start
class Solution {
    public int minDeletion(int[] nums) {
        // 双端队列
        return extracted(nums);
    }

    /**
     * 114/114 cases passed (13 ms)
     * Your runtime beats 23.85 % of java submissions
     * Your memory usage beats 44.06 % of java submissions (56 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(nums[0]);
        for (int i = 1; i < n; i++) {
            /*
             * 对所有满足 i % 2 == 0 的下标 i ，
             * nums[i] != nums[i + 1] 均成立
             * 当栈的大小为偶数时，说明此时可以将数据直接添加到栈中
             */
            if (deque.size() % 2 == 0) {
                deque.push(nums[i]);
            } else {
                int val = deque.peek();
                // 当为奇数时，要判断是否与栈顶的元素相同，如果相同，则不能添加
                if (nums[i] == val)
                    continue;
                deque.push(nums[i]);
            }
        }
        if (deque.size() % 2 == 0)
            return n - deque.size();
        // 当栈的大小为奇数时，需要减去栈顶元素，所以删除的次数要加1
        return n - deque.size() + 1;
    }
}
// @lc code=end
