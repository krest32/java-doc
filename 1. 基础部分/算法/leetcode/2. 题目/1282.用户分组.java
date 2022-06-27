import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1282 lang=java
 *
 * [1282] 用户分组
 */

// @lc code=start
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // 哈希实现
        // 更新一步： 利用數組代替Map，性能会有所提升
        return extracted(groupSizes);
    }

    /**
     * 103/103 cases passed (7 ms)
     * Your runtime beats 48.76 % of java submissions
     * Your memory usage beats 5.38 % of java submissions (42.4 MB)
     * 
     * @param groupSizes
     * @return
     */
    private List<List<Integer>> extracted(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int idx = groupSizes[i];
            List<Integer> temp = map.getOrDefault(idx, new ArrayList<>());
            if (temp.size() < idx) {
                temp.add(i);
                if (temp.size() == idx) {
                    ans.add(new ArrayList<>(temp));
                    List<Integer> newList = new ArrayList<>();
                    map.put(idx, newList);
                } else {
                    map.put(idx, temp);
                }
            }
        }
        return ans;
    }
}
// @lc code=end
