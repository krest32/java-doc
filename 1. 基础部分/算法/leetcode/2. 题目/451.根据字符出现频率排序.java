import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        // 哈希
        // return extracted(s);

        // 1
        return test(s);
    }

    private String test(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            char ch = list.get(i).getKey();
            int count = list.get(i).getValue();
            for (int j = 0; j < count; j++) {
                res.append(ch);
            }
        }
        return res.toString();
    }

    /**
     * Your runtime beats 74.25 % of java submissions
     * Your memory usage beats 77.27 % of java submissions (41.6 MB)
     * 
     * @param s
     * @return
     */
    private String extracted(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            char ch = list.get(i).getKey();
            Integer count = list.get(i).getValue();
            for (int j = 0; j < count; j++) {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
// @lc code=end
