import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1711 lang=java
 *
 * [1711] 大餐计数
 */

// @lc code=start
class Solution {

    int ret = 0;

    public int countPairs(int[] deliciousness) {
        // 暴力 ： 超时
        // return extracted(deliciousness);

        // 枚举 + 哈希
        return extracted2(deliciousness);

    }

    private int extracted2(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        // 比较获取最大值
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        // 设定最大
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = deliciousness.length;

        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            // 将2的幂次方记录到Map中
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }

    private int extracted(int[] deliciousness) {
        final int MOD = 1000000007;
        int len = deliciousness.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = deliciousness[i] + deliciousness[j];
                if (check(sum)) {
                    ret = (ret + 1) % MOD;
                }
            }
        }
        return ret;
    }

    boolean check(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
// @lc code=end
