import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1128 lang=java
 *
 * [1128] 等价多米诺骨牌对的数量
 */

// @lc code=start
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        // 排序+双指针
        // return extracted(dominoes);

        // 二元数组+计数
        return extracted2(dominoes);

    }

    /**
     * Your runtime beats 96.85 % of java submissions
     * Your memory usage beats 41.55 % of java submissions (50.2 MB)
     * 
     * @param dominoes
     * @return
     */
    private int extracted2(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1]
                    ? domino[0] * 10 + domino[1]
                    : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }

    /**
     * Your runtime beats 5.16 % of java submissions
     * Your memory usage beats 19.77 % of java submissions (50.5 MB)
     * 
     * @param dominoes
     * @return
     */
    private int extracted(int[][] dominoes) {
        for (int[] arr : dominoes) {
            Arrays.sort(arr);
        }

        Arrays.sort(dominoes, (o1, o2) -> {
            return o1[0] - o2[0] != 0
                    ? o1[0] - o2[0]
                    : o1[1] - o2[1];
        });

        int ans = 0;
        // 双指针
        for (int i = 0; i < dominoes.length; i++) {
            int[] temp = dominoes[i];
            int j = i + 1;
            while (j < dominoes.length && temp[0] == dominoes[j][0] && temp[1] == dominoes[j][1]) {
                j++;
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end
