import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 截取固定長的的字符串，变为字符数组, 
        // 然后排序判断子字符串是否与目标字符串相等
        return extracted(s, p);
    }

    private List<Integer> extracted(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }
        int len = p.length();
        char[] pChar = p.toCharArray();
        Arrays.sort(pChar);
        for (int i = 0; i < s.length(); i++) {
            if (i + len <= s.length()) {
                String tempStr = s.substring(i, i + len);
                char[] tempCharArr = tempStr.toCharArray();
                Arrays.sort(tempCharArr);
                if (Arrays.equals(pChar, tempCharArr)) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
// @lc code=end
