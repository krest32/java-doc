import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        return extracted(pattern, s);
    }

    /**
     * Your runtime beats 68.24 % of java submissions
     * Your memory usage beats 41.86 % of java submissions (39 MB)
     * 
     * @param pattern
     * @param s
     * @return
     */
    private boolean extracted(String pattern, String s) {
        int pLen = pattern.length();
        String[] sArr = s.split(" ");
        int sLen = sArr.length;
        if (pLen != sLen)
            return false;
        // hash 建立类型和字符数组之间的映射
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            char ch = pattern.charAt(i);
            //
            if (map.containsKey(ch) && !map.get(ch).equals(sArr[i])) {
                return false;
            } else if (map.containsKey(ch) && map.get(ch).equals(sArr[i])) {
                continue;
            } else {
                for (Map.Entry<Character, String> entry : map.entrySet()) {
                    if (entry.getValue().equals(sArr[i]))
                        return false;
                }
                map.put(pattern.charAt(i), sArr[i]);
            }
        }
        return true;
    }
}
// @lc code=end
