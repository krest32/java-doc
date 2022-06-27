/*
 * @lc app=leetcode.cn id=949 lang=java
 *
 * [949] 给定数字能组成的最大时间
 */

// @lc code=start
class Solution {

    String res;

    public String largestTimeFromDigits(int[] arr) {
        // 回溯 + 条件选择
        return extracted(arr);
    }

    /**
     * Your runtime beats 80.57 % of java submissions
     * Your memory usage beats 7.28 % of java submissions (41.4 MB)
     * 
     * @param arr
     * @return
     */
    private String extracted(int[] arr) {
        boolean[] vis = new boolean[4];
        dfs(arr, new StringBuilder(), vis);
        return res == null ? "" : res.substring(0, 2) + ":" + res.substring(2, 4);
    }

    private void dfs(int[] arr,
            StringBuilder temp,
            boolean[] vis) {
        if (temp.length() == 4) {
            int hour = Integer.valueOf(temp.substring(0, 2));
            int min = Integer.valueOf(temp.substring(2, 4));
            if (hour < 24 && min < 60) {
                if (res == null) {
                    res = new String(temp);
                }
                if (res.length() == 4) {
                    int resHour = Integer.valueOf(res.substring(0, 2));
                    int resMin = Integer.valueOf(res.substring(2, 4));
                    if (hour > resHour || (hour == resHour && min > resMin))
                        res = new String(temp);
                }
            }
        }
        // 递归所有的可能性
        for (int i = 0; i < 4; i++) {
            if (!vis[i]) {
                vis[i] = true;
                temp.append(String.valueOf(arr[i]));
                dfs(arr, temp, vis);
                temp.deleteCharAt(temp.length() - 1);
                vis[i] = false;
            }
        }
    }
}
// @lc code=end
