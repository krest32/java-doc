/*
 * @lc app=leetcode.cn id=1299 lang=java
 *
 * [1299] 将每个元素替换为右侧最大元素
 */

// @lc code=start
class Solution {
    public int[] replaceElements(int[] arr) {

        int rightMax = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        // 逆序遍历
        for (int i = arr.length - 2; i >= 0; i--) {
            // 临时变量
            int t = arr[i];
            // 最大值替换当前
            arr[i] = rightMax;
            // 逆序获取最大值
            if (t > rightMax) {
                rightMax = t;
            }
        }
        return arr;
    }
}
// @lc code=end
