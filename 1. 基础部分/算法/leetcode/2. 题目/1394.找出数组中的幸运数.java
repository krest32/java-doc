import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1394 lang=java
 *
 * [1394] 找出数组中的幸运数
 */

// @lc code=start
class Solution {
    public int findLucky(int[] arr) {
        // 哈希
        return extracted(arr);
    }

    private int extracted(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (key == value) {
                ans = Math.max(ans, key);
            }
        }
        return ans;
    }
}
// @lc code=end
