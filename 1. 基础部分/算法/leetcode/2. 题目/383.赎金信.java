/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 模拟
        return extracted(ransomNote, magazine);
    }

    /**
     * Your runtime beats 99.86 % of java submissions
     * Your memory usage beats 15.12 % of java submissions (41.5 MB)
     * 
     * @param ransomNote
     * @param magazine
     * @return
     */
    private boolean extracted(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;
        int[] ans = new int[26];
        for (char ch : magazine.toCharArray()) {
            ans[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            ans[ch - 'a']--;
            if (ans[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
