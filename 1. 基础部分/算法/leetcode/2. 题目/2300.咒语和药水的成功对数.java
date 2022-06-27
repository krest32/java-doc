import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2300 lang=java
 *
 * [2300] 咒语和药水的成功对数
 */

// @lc code=start
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // 暴力超时
        return extracted(spells, potions, success)

        // 二分查找法
        return extracted2(spells, potions, success);
    }

    /**
     * 56/56 cases passed (27 ms)
     * Your runtime beats 97.06 % of java submissions
     * Your memory usage beats 9.98 % of java submissions (61.9 MB)
     * 
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    private int[] extracted2(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        // 必须要转发为long类型，不然超范围
        long[] arr = new long[potions.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = potions[i];
        }
        for (int i = 0; i < spells.length; i++) {
            // 二分查找arr[index] * spell[i]>=target的第一个数据
            int index = search(arr, spells[i], success);
            ans[i] = potions.length - index;
        }

        return ans;
    }

    // 二分查找arr[index] * spell[i]>=target的第一个数据
    private int search(long[] arr, long x, long target) {
        if (arr[arr.length - 1] * x < target)
            return arr.length;// 对边界进行处理
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] * x >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return r;
    }

    /**
     * 
     * Wrong Answer
     * 48/56 cases passed (N/A)
     */
    private int[] extracted(int[] spells, int[] potions, long success) {
        int len1 = spells.length;
        int len2 = potions.length;

        int[] ans = new int[len1];

        for (int i = 0; i < len1; i++) {
            int cnt = 0;
            for (int j = 0; j < len2; j++) {
                int target = spells[i] * potions[j];
                if (target >= success) {
                    cnt++;
                }
            }
            ans[i] = cnt;
        }

        return ans;
    }
}
// @lc code=end
