import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        // 哈希 --> 效率低
        // return extracted(s, t);

        // 数组映射 --> 最优解
        return extracted2(s, t);
    }

    /**
     * 数组映射
     * 
     * Your runtime beats 98.06 % of java submissions
     * Your memory usage beats 30.5 % of java submissions (41.1 MB)
     * 
     * ASCII第一次以规范标准的类型发表是在1967年，
     * 最后一次更新则是在1986年，到目前为止共定义了128个字符
     * 
     * @param s
     * @param t
     * @return
     */
    private boolean extracted2(String s, String t) {
        int n = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            // 当前的映射值是否相同
            if (mapS[c1] != mapT[c2]) {
                return false;
            } else {
                // 是否已经修改过，修改过就不需要再处理
                if (mapS[c1] == 0) {
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        return true;
    }

    /**
     * 哈希
     * 
     * @param s
     * @param t
     * @return
     */
    private boolean extracted(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            // 如果出现冲突（即当前下标 index 对应的字符 s[index] 已经存在映射
            // 且不为 t[index] 或当前下标 index 对应的字符 t[index] 已经存在映射
            // 且不为 s[index]）时说明两个字符串无法构成同构，返回 false。
            if ((sMap.containsKey(sChar) && sMap.get(sChar) != tChar)
                    || (tMap.containsKey(tChar) && tMap.get(tChar) != sChar)) {
                return false;
            }
            sMap.put(sChar, tChar);
            tMap.put(tChar, sChar);
        }
        return true;
    }
}
// @lc code=end
