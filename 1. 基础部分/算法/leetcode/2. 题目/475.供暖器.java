import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=475 lang=java
 *
 * [475] 供暖器
 */

// @lc code=start
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // 绝对值+双指针
        // return extracted(houses, heaters);

        // 1
        return test(houses, heaters);
    }

    int test(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            // 计算房屋到加热器的距离
            int curDis = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1
                    && curDis >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDis = Math.min(curDis, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, curDis);
        }
        return ans;
    }

    /**
     * Your runtime beats 65.13 % of java submissions
     * Your memory usage beats 73.54 % of java submissions (43.1 MB)
     * 
     * @param houses
     * @param heaters
     * @return
     */
    private int extracted(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            int curDistance = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1
                    && curDistance >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }
}
// @lc code=end
