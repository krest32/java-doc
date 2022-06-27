import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/*
 * @lc app=leetcode.cn id=792 lang=java
 *
 * [792] 匹配子序列的单词数
 */
import java.util.Set;

// @lc code=start
class Solution {
    int ans = 0;

    public int numMatchingSubseq(String s, String[] words) {
        // 全排列，生成所有的字符串 -> 超时（要构建所有的S子串）
        // return extracted(s, words);

        // 双指针 --> 超时（每次都要遍历一遍s）
        // return extracted2(s, words);

        // 双指针改进 --> 仍然超时
        // return extracted4(s, words);

        // 双指改进 --> 去掉重复的需要判断的字符
        return extracted3(s, words);
    }

    private int extracted4(String s, String[] words) {
        int len1 = s.length();
        Set<String> set = new HashSet<>();
        for (String tempStr : words) {
            // 去重
            if (set.contains(tempStr)) {
                ans++;
                continue;
            } else {
                int idx1 = 0;
                int idx2 = 0;
                int len2 = tempStr.length();
                while (idx1 < len1 && idx2 < len2) {
                    if (s.charAt(idx1) == tempStr.charAt(idx2)) {
                        idx2++;
                    }
                    idx1++;
                }
                if (idx2 == tempStr.length()) {
                    set.add(tempStr);
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * Your runtime beats 31.56 % of java submissions
     * Your memory usage beats 70.43 % of java submissions (42.1 MB)
     * 
     * @param s
     * @param words
     * @return
     */
    private int extracted3(String s, String[] words) {
        int output = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        for (String key : map.keySet()) {
            if (isSubSequence(s, key)) {
                output += map.get(key);
            }
        }
        return output;
    }

    private boolean isSubSequence(String S, String W) {
        int iS = 0;
        int iW = 0;
        while (iS < S.length() && iW < W.length()) {
            if (S.charAt(iS) == W.charAt(iW)) {
                iW++;
            }
            iS++;
        }
        return iW == W.length();

    }

    private boolean check(List<Integer> last, int K) {
        for (int i = 0; i < last.size(); i++) {
            if (last.get(i) < K) {
                return true;
            }
        }
        return false;
    }

    private int extracted2(String s, String[] words) {
        int len1 = s.length();
        for (String tempStr : words) {
            int idx1 = 0;
            int idx2 = 0;
            int len2 = tempStr.length();
            while (idx1 < len1 && idx2 < len2) {
                if (s.charAt(idx1) == tempStr.charAt(idx2)) {
                    idx1++;
                    idx2++;
                } else {
                    idx1++;
                }
            }
            if (idx2 == tempStr.length()) {
                ans++;
            }
        }
        return ans;
    }

    private int extracted(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String tempStr : words)
            map.put(tempStr, map.getOrDefault(tempStr, 0) + 1);
        dfs(s, map, new StringBuilder(), 0);
        return ans;
    }

    private void dfs(String s, Map<String, Integer> map, StringBuilder temp, int idx) {

        if (map.containsKey(temp.toString())) {
            int count = map.get(temp.toString());
            ans += count;
            map.remove(temp.toString());
        }

        for (int i = idx; i < s.length(); i++) {
            temp.append(s.charAt(i));
            dfs(s, map, temp, i + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
// @lc code=end
