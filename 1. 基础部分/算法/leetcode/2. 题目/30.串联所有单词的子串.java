import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
class Solution {
    
    List<Integer> ans = new ArrayList<Integer>();
    Set<Integer> set = new HashSet<Integer>();

    public List<Integer> findSubstring(String s, String[] words) {
        if (words[0].length() > s.length())
            return ans;
        int n = words.length;
        int len = words[0].length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(words[i]))
                map.replace(words[i], map.get(words[i]) + 1);
            else
                map.put(words[i], 1);
        }

        for (int x = 0; x < s.length() - n * len + 1; x++) {
            HashMap<String, Integer> tmp = (HashMap<String, Integer>) map.clone();
            for (int i = x; i < x + n * len; i = i + len) {
                if (!tmp.containsKey(s.substring(i, i + len)))
                    break;
                else {
                    if (tmp.get(s.substring(i, i + len)) == 1) {
                        tmp.remove(s.substring(i, i + len));
                    } else if (tmp.get(s.substring(i, i + len)) > 1)
                        tmp.replace(s.substring(i, i + len), tmp.get(s.substring(i, i + len)) - 1);
                }
                if (tmp.isEmpty() && set.add(i - len * (n - 1)))
                    ans.add(i - len * (n - 1));
            }
        }
        return ans;
    }
}
// @lc code=end
