import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=539 lang=java
 *
 * [539] 最小时间差
 */

// @lc code=start
class Solution {
    public int findMinDifference(List<String> timePoints) {
        // 暴力性能較低
        return extracted(timePoints);
    }

    /**
     * Your runtime beats 16.99 % of java submissions
     * Your memory usage beats 5.03 % of java submissions (42.8 MB)
     * 
     * @param timePoints
     * @return
     */
    private int extracted(List<String> timePoints) {
        Collections.sort(timePoints);
        int len = timePoints.size();
        int[] minutes = new int[len];
        for (int i = 0; i < len; i++) {
            minutes[i] = getMin(timePoints.get(i));
        }
        String[] strs = timePoints.get(0).split(":");
        int start = strs[0].equals("00") ? 24 * 60 + Integer.valueOf(strs[1])
                : Integer.valueOf(strs[0]) * 60 + Integer.valueOf(strs[1]);
        int diff = Math.abs(minutes[len - 1] - start);
        diff = Math.min(diff, Math.abs(minutes[len - 1] - getMax(timePoints.get(0))));
        for (int i = 1; i < len; i++) {
            diff = Math.min(diff, Math.abs(minutes[i] - minutes[i - 1]));
        }
        return diff;
    }

    private int getMin(String str) {
        String[] strs = str.split(":");
        if (strs[0].equals("00")) {
            strs[0] = "24";
        }
        if (strs[0].equals("24") && !(strs[1].equals("00"))) {
            return Integer.valueOf(strs[1]);
        }

        if (strs[1].equals("24") && strs[1].equals("00")) {
            return Integer.valueOf(strs[0]) * 60;
        }
        return Integer.valueOf(strs[0]) * 60 + Integer.valueOf(strs[1]);
    }

    private int getMax(String str) {
        String[] strs = str.split(":");
        int hours = Integer.valueOf(strs[0]);
        return (hours + 24) * 60 + Integer.valueOf(strs[1]);

    }
}
// @lc code=end
