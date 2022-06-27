import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1481 lang=java
 *
 * [1481] 不同整数的最少数目
 */

// @lc code=start
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        // 哈希计数
        return method(arr, k);

    }

    /**
     * Your runtime beats 50.43 % of java submissions
     * Your memory usage beats 88.46 % of java submissions (49.8 MB)
     * 
     * @param arr
     * @param k
     * @return
     */
    int method(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        // 安装出现的次数升序排序
        list.sort((o1, o2) -> {
            return o1.getValue() - o2.getValue();
        });
        int ans = list.size();
        for (int i = 0; i < list.size(); i++) {
            int cnt = list.get(i).getValue();
            if (k >= cnt) {
                k = k - cnt;
                ans--;
            }
        }
        return ans;

    }
}
// @lc code=end
