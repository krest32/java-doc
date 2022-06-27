import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=599 lang=java
 *
 * [599] 两个列表的最小索引总和
 */

// @lc code=start
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        // 哈希
        // return extracted(list1, list2);

        // 哈希改进
        return extracted2(list1, list2);

    }

    /**
     * Your runtime beats 78.35 % of java submissions
     * Your memory usage beats 11.56 % of java submissions (42.1 MB)
     * 
     * @param list1
     * @param list2
     * @return
     */
    private String[] extracted2(String[] list1, String[] list2) {
        int n = list1.length, m = list2.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(list1[i], i);
        List<String> ans = new ArrayList<>();
        int min = 3000;
        for (int i = 0; i < m; i++) {
            String s = list2[i];
            if (!map.containsKey(s))
                continue;
            if (i + map.get(s) < min) {
                ans.clear();
                min = i + map.get(s);
                ans.add(s);
            } else if (i + map.get(s) == min) {
                ans.add(s);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }

    /**
     * Your runtime beats 5.14 % of java submissions
     * Your memory usage beats 39.64 % of java submissions (41.8 MB)
     * 
     * @param list1
     * @param list2
     * @return
     */
    private String[] extracted(String[] list1, String[] list2) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j))
                        map.put(i + j, new ArrayList<String>());
                    map.get(i + j).add(list1[i]);
                }
            }
        }
        int min_index_sum = Integer.MAX_VALUE;
        for (int key : map.keySet())
            min_index_sum = Math.min(min_index_sum, key);
        String[] res = new String[map.get(min_index_sum).size()];
        return map.get(min_index_sum).toArray(res);
    }
}
// @lc code=end
