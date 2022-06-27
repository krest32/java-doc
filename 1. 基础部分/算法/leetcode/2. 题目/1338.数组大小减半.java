import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1338 lang=java
 *
 * [1338] 数组大小减半
 */

// @lc code=start
class Solution {
    public int minSetSize(int[] arr) {
        return extracted(arr);
    }

    /**
     * 33/33 cases passed (34 ms)
     * Your runtime beats 47.06 % of java submissions
     * Your memory usage beats 74.79 % of java submissions (49.7 MB)
     * 
     * @param arr
     * @return
     */
    private int extracted(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int cnt = map.getOrDefault(arr[i], 0);
            map.put(arr[i], cnt + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry);
        }

        // 根据出现次数进行排序
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int cnt = 0;
        int ans = 0;
        int half = len / 2;
        for (int i = 0; i < list.size(); i++) {
            cnt += list.get(i).getValue();
            ans++;
            if (cnt >= half) {
                break;
            }
        }
        return ans;
    }
}
// @lc code=end
