import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 模拟，使用hash
        return extracted(strs);
    }

    /**
     * Your runtime beats 88.52 % of java submissions
     * Your memory usage beats 5.37 % of java submissions (45.2 MB)
     */
    private List<List<String>> extracted(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String tempStr = strs[i];
            char[] tempCharArr = tempStr.toCharArray();
            Arrays.sort(tempCharArr);

            List<String> list = map.getOrDefault(new String(tempCharArr), new ArrayList<String>());
            list.add(tempStr);
            map.put(new String(tempCharArr), list);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
// @lc code=end
