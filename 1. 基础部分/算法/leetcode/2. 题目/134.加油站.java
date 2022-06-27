/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 贪心
        // return extracted(gas, cost);

        // 1
        return test(gas, cost);
    }

    private int test(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumGas = 0;
            int sumCost = 0;
            int cnt = 0;
            while (cnt < n) {
                // 求余数，确认目前达到了第几个加油站
                int j = (i + cnt) % n;
                sumGas += gas[j];
                sumCost += cost[j];
                if (sumCost > sumGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                // 跳过需要重新计算的部分
                i = i + 1 + cnt;
            }
        }
        return -1;
    }

    /**
     * Your runtime beats 77.31 % of java submissions
     * Your memory usage beats 51.49 % of java submissions (60.8 MB)
     * 
     * @param gas
     * @param cost
     * @return
     */
    private int extracted(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                // 记录需要的油
                sumOfGas += gas[j];
                // 记录花费的油
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            // 判断是否走完一圈
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
// @lc code=end
