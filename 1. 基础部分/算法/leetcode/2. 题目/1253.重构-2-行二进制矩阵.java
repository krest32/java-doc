import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1253 lang=java
 *
 * [1253] 重构 2 行二进制矩阵
 */

// @lc code=start
class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower,
            int[] colsum) {
        // 模拟
        return extracted(upper, lower, colsum);
    }

    /**
     * Your runtime beats 51.52 % of java submissions
     * Your memory usage beats 75.76 % of java submissions (49.9 MB)
     * 
     * @param upper
     * @param lower
     * @param colsum
     * @return
     */
    private List<List<Integer>> extracted(int upper, int lower, int[] colsum) {
        int sum = 0;
        int len = colsum.length;

        List<List<Integer>> ans = new ArrayList<>();
        int down = 0;
        for (int num : colsum) {
            down += num == 2 ? 1 : 0;
            sum += num;
        }
        // 满足如下条件，无法分
        if (sum != upper + lower || down > upper || down > lower)
            return ans;

        int up = upper - down;// upper可以承担的1的数量
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        int idx = 0;
        while (idx < len) {
            if (colsum[idx] == 2) {
                one.add(idx, 1);
                two.add(idx, 1);
            } else if (colsum[idx] == 1) {
                if (up > 0) {
                    one.add(idx, 1);
                    two.add(idx, 0);
                    up--;
                } else {
                    two.add(idx, 1);
                    one.add(idx, 0);
                }
            } else {
                one.add(idx, 0);
                two.add(idx, 0);
            }
            idx++;
        }
        ans.add(one);
        ans.add(two);
        return ans;
    }
}
// @lc code=end
