import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=969 lang=java
 *
 * [969] 煎饼排序
 */

// @lc code=start
class Solution {
    // 类似于冒泡排序，但是真他妈的绕来绕去的
    public List<Integer> pancakeSort(int[] arr) {
        // arr 数组是从1到n的排列
        int n = arr.length;
        int[] idx = new int[n + 10];
        // 记录数组中每个元素的下标值
        for (int i = 0; i < n; i++)
            idx[arr[i]] = i;
        List<Integer> ans = new ArrayList<>();

        for (int i = n; i >= 1; i--) {
            //
            int id = idx[i];
            // 如果这个位置的数字正确，那么不进行操作
            if (id == i - 1)
                continue;
            // 开始翻转
            if (id != 0) {
                // 记录翻转的数字大小
                ans.add(id + 1);
                reverse(arr, 0, id, idx);
            }
            ans.add(i);
            reverse(arr, 0, i - 1, idx);
        }
        return ans;
    }

    private void reverse(int[] arr, int i, int id, int[] idx) {
        while (i < id) {
            idx[arr[i]] = id;
            idx[arr[id]] = i;
            int c = arr[i];
            arr[i++] = arr[id];
            arr[id--] = c;
        }
    }
}
// @lc code=end
