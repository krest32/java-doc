import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2171 lang=java
 *
 * [2171] 拿出最少数目的魔法豆
 */

// @lc code=start
class Solution {
    public long minimumRemoval(int[] beans) {
        /**
         * 暴力解法：排序 + 计算每一个豆子，超时
         * 具有很多的优化空间
         */
        // return extracted(beans);

        // 暴力优化 --> 性能比较差
        // return extracted2(beans);

        // 转变为数序问题 -> 需要注意数据边界的问题
        return extracted3(beans);
    }

    /**
     * Your runtime beats 94.46 % of java submissions
     * Your memory usage beats 11.19 % of java submissions (60.8 MB)
     * 
     * @param beans
     * @return
     */
    private long extracted3(int[] beans) {
        int len = beans.length;
        Arrays.sort(beans);
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += beans[i];
        }
        long res = 9223372036854775807L;
        for (int i = 0; i < len; i++) {
            res = Math.min(res, sum - (long) ((long) beans[i] * (len - i)));
        }
        return res;
    }

    /**
     * Your runtime beats 16.42 % of java submissions
     * Your memory usage beats 95.28 % of java submissions (55.4 MB)
     */
    private long extracted2(int[] beans) {
        long ans = 9223372036854775807L;
        int n = beans.length;
        long[] sum = new long[n + 1];
        Arrays.sort(beans);
        // 记录所有的累加和，避免重复计算
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + beans[i];
        }
        for (int i = 0; i < n; i++) {
            if (i > 0 && beans[i] == beans[i - 1])
                continue;
            long h = 0;
            if (i > 0)
                h += sum[i];
            h += sum[n] - sum[i + 1] - (long) beans[i] * (n - i - 1);
            ans = Math.min(ans, h);
        }
        return ans;
    }

    private long extracted(int[] beans) {
        Arrays.sort(beans);
        // 所有的袋子为 null
        long sum = Arrays.stream(beans).sum();
        int len = beans.length;

        int idx = 0;
        while (idx < len) {
            long curSum = 0;
            long curNum = beans[idx];
            // 先计算前面所有的袋子置空的总和
            for (int j = 0; j < idx; j++) {
                curSum += beans[j];
            }
            // 然后计算剩余袋子的差值
            for (int i = idx; i < len; i++) {
                curSum += beans[i] - curNum;
            }
            sum = Math.min(sum, curSum);
            idx++;
        }
        return sum;
    }
}
// @lc code=end
