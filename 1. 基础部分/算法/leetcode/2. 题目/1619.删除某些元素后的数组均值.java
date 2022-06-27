import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1619 lang=java
 *
 * [1619] 删除某些元素后的数组均值
 */

// @lc code=start
class Solution {
    public double trimMean(int[] arr) {
        // 模拟，根据题意
        // return extracted(arr);

        // 性能有所提升，但是不大
        return extracted2(arr);
    }

    /**
     * 50/50 cases passed (3 ms)
     * Your runtime beats 13.09 % of java submissions
     * Your memory usage beats 34.9 % of java submissions (41.2 MB)
     * 
     * @param arr
     * @return
     */
    private double extracted2(int[] arr) {
        int len = arr.length;
        int delNum = (int) (len * 0.05);
        Arrays.sort(arr);
        int sum = 0;
        for (int i = delNum; i < len - delNum; i++) {
            sum += arr[i];
        }
        int curNum = len - delNum * 2;
        if (curNum > 0) {
            return (double) sum / curNum;
        }
        return 0;
    }

    /**
     * 50/50 cases passed (4 ms)
     * Your runtime beats 8.05 % of java submissions
     * Your memory usage beats 54.36 % of java submissions (41 MB)
     * 
     * @param arr
     * @return
     */
    private double extracted(int[] arr) {
        int len = arr.length;
        int delNum = (int) (len * 0.05);
        Arrays.sort(arr);
        for (int i = 0; i < delNum; i++) {
            arr[i] = 0;
            arr[len - 1 - i] = 0;
        }

        int sum = Arrays.stream(arr).sum();
        int curNum = len - delNum * 2;
        if (curNum > 0) {
            return (double) sum / curNum;
        }
        return 0;
    }
}
// @lc code=end
