/*
 * @lc app=leetcode.cn id=2029 lang=java
 *
 * [2029] 石子游戏 IX
 */

// @lc code=start
class Solution {
    public boolean stoneGameIX(int[] stones) {
        // 博弈论
        return extracted(stones);

    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 5.12 % of java submissions (51.5 MB)
     * 
     * @param stones
     * @return
     */
    private boolean extracted(int[] stones) {
        int[] cnts = new int[3];
        for (int i : stones)
            cnts[i % 3]++;
        return cnts[0] % 2 == 0 ? !(cnts[1] == 0 || cnts[2] == 0)
                : !(Math.abs(cnts[1] - cnts[2]) <= 2);
    }
}
// @lc code=end
