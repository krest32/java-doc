import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=916 lang=java
 *
 * [916] 单词子集
 */

// @lc code=start
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // 模拟
        return extracted(words1, words2);
    }

    /**
     * Your runtime beats 37.75 % of java submissions
     * Your memory usage beats 34.43 % of java submissions (49.2 MB)
     * 
     * @param words1
     * @param words2
     * @return
     */
    private List<String> extracted(String[] words1, String[] words2) {
        List<String> ret = new ArrayList<>();
        // 统计words2字符数
        int[] cnt = new int[26];
        for (int i = 0; i < words2.length; i++) {
            String temp = words2[i];
            int[] tempCnt = new int[26];
            for (int j = 0; j < temp.length(); j++) {
                tempCnt[temp.charAt(j) - 'a']++;
                cnt[temp.charAt(j) - 'a'] = Math.max(cnt[temp.charAt(j) - 'a'],
                        tempCnt[temp.charAt(j) - 'a']);
            }
        }

        for (int i = 0; i < words1.length; i++) {
            if (check(words1[i], cnt)) {
                ret.add(words1[i]);
            }
        }
        return ret;
    }

    boolean check(String str, int[] map) {
        int[] cnt = new int[26];
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] < map[i]) {
                return false;
            }
        }
        return true;
    }

}
// @lc code=end
