/*
 * @lc app=leetcode.cn id=1894 lang=java
 *
 * [1894] 找到需要补充粉笔的学生编号
 */

// @lc code=start
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // 模拟 -> 注意数值边界问题
        return extracted(chalk, k);
    }

    /**
     * Your runtime beats 51.84 % of java submissions
     * Your memory usage beats 40 % of java submissions (54.2 MB)
     * 
     * @param chalk
     * @param k
     * @return
     */
    private int extracted(int[] chalk, int k) {
        long sum = 0;
        int len = chalk.length;
        for (int i = 0; i < len; i++) {
            sum += chalk[i];
        }
        int idx = 0;
        long num = k % sum;

        // 计算小于当前封笔数小于需求数的学生编号
        for (int i = 0; i < len; i++) {
            if (num >= chalk[i]) {
                num -= chalk[i];
            } else {
                idx = i;
                break;
            }
        }
        return idx;
    }
}
// @lc code=end
