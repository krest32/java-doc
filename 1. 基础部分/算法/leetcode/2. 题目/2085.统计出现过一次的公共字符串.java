import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=2085 lang=java
 *
 * [2085] 统计出现过一次的公共字符串
 */

// @lc code=start
class Solution {
    public int countWords(String[] words1, String[] words2) {
        // 哈希
        return extracted(words1, words2);
    }

    /**
     * Your runtime beats 75.12 % of java submissions
     * Your memory usage beats 25.59 % of java submissions (41.3 MB)
     * 
     * @param words1
     * @param words2
     * @return
     */
    private int extracted(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        int len1 = words1.length;
        int len2 = words2.length;
        for (int i = 0; i < len1; i++) {
            int count = map1.getOrDefault(words1[i], 0);
            map1.put(words1[i], count + 1);
        }
        for (int i = 0; i < len2; i++) {
            int count = map2.getOrDefault(words2[i], 0);
            map2.put(words2[i], count + 1);
        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1
                    && map2.getOrDefault(entry.getKey(), 0) == 1) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end
