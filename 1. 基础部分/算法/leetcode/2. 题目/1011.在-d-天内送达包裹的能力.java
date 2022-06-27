
/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * 、
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }

        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 判断能够运输的货物下标
    private boolean check(int[] weights, int mid, int days) {
        int n = weights.length;
        int cnt = 1;
        for (int i = 1, sum = weights[0]; i < n; sum = 0, cnt++) {
            while (i < n && sum + weights[i] <= mid) {
                sum += weights[i];
                i++;
            }
        }
        return cnt - 1 <= days;
    }

}
// @lc code=end
