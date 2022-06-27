import org.w3c.dom.css.CSS2Properties;

import javafx.scene.chart.PieChart.Data;
import javafx.stage.Modality;

/*
 * @lc app=leetcode.cn id=983 lang=java
 *
 * [983] 最低票价
 */

// @lc code=start
class Solution {

    int[] days, costs;
    Integer[] memo;
    int[] dura = { 1, 7, 30 };

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        // 记录对应日期的最小花费
        memo = new Integer[days.length];
        return dp(0);
    }

    //
    private int dp(int i) {
        if (i >= days.length) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }

        int j = i;
        memo[i] = Integer.MAX_VALUE;
        for (int k = 0; k < 3; k++) {
            // 从后向前，记录下次花费能够达到j的最小花费
            while (j < days.length && days[j] < days[i] + dura[k]) {
                j++;
            }
            memo[i] = Math.min(memo[i], dp(j) + costs[k]);
        }
        return memo[i];
    }
}
// @lc code=end
