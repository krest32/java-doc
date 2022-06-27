import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1287 lang=java
 *
 * [1287] 有序数组中出现次数超过25%的元素
 */

// @lc code=start
class Solution {
    public int findSpecialInteger(int[] arr) {
        // 哈希
        // return extracted(arr);

        // 巧用数字占比
        return extracted2(arr);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 5.42 % of java submissions (42 MB)
     * 
     * @param arr
     * @return
     */
    private int extracted2(int[] arr) {
        int t = arr.length;
        int t1 = t / 4;
        for (int i = 0; i < t - t1; i++) {
            if (arr[i] == arr[i + t1]) {
                return arr[i];
            }
        }

        return arr[0];
    }

    /**
     * Your runtime beats 8.25 % of java submissions
     * Your memory usage beats 12.89 % of java submissions (41.8 MB)
     * 
     * @param arr
     * @return
     */
    private int extracted(int[] arr) {
        int result = 0;
        int arrId = 0;
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : arr) {
            if (map.get(num) > result) {
                result = map.get(num);
                arrId = num;
            }
        }
        return arrId;
    }
}
// @lc code=end
