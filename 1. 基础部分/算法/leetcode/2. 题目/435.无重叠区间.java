import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = intervals[i];
            int start = temp[0];
            if (end <= start) {
                count += 1;
                end = temp[1];
            }
        }
        return intervals.length - count;
    }
}
// @lc code=end
