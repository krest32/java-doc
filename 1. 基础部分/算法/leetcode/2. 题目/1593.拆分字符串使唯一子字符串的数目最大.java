import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1593 lang=java
 *
 * [1593] 拆分字符串使唯一子字符串的数目最大
 */

// @lc code=start
class Solution {
    int maxSplit = 1;

    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        backTracking(s, set, 0, 0);
        return maxSplit;

    }

    /**
     * 
     * Your runtime beats 55.46 % of java submissions
     * Your memory usage beats 27.73 % of java submissions (41.5 MB)
     * 
     * @param s     字符串s
     * @param set   保存子字符串的集合
     * @param idx   记录字符串截取的位置
     * @param split 记录被截取的字符串的个数
     */
    private void backTracking(String s,
            Set<String> set,
            int idx,
            int split) {
        int length = s.length();
        if (idx == length) {
            maxSplit = Math.max(maxSplit, split);
        } else {
            for (int i = idx; i < s.length(); i++) {
                String subStr = s.substring(idx, i + 1);
                if (set.add(subStr)) {
                    backTracking(s, set, i + 1, split + 1);
                    set.remove(subStr);
                }
            }
        }
    }
}
// @lc code=end
