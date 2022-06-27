
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有 K 个重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        // 官方解答
        // return extracted(s, k);

        // hash
        // return extracted2(s, k);

        // 1
        return test(s, k);

    }

    /**
     * 35/35 cases passed (5 ms)
     * Your runtime beats 36.32 % of java submissions
     * Your memory usage beats 36.53 % of java submissions (41 MB)
     * 
     * @param s
     * @param k
     * @return
     */
    private int test(String s, int k) {
        if (s.length() < k)
            return 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (char ch : map.keySet()) {
            if (map.get(ch) < k) {
                int res = 0;
                for (String t : s.split(String.valueOf(ch))) {
                    res = Math.max(res, test(t, k));
                }
                return res;
            }
        }
        return s.length();
    }

    /**
     * Your runtime beats 56.65 % of java submissions
     * Your memory usage beats 17.74 % of java submissions (41.2 MB)
     * 
     * @param s
     * @param k
     * @return
     */
    private int extracted2(String s, int k) {
        if (s.length() < k)
            return 0;
        HashMap<Character, Integer> counter = new HashMap<>();
        // 记录当前String，每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        // 遍历Map集合
        for (char c : counter.keySet()) {
            // 如果该字符串数组包含c(count(c)<k)，那么一定不满足条件
            if (counter.get(c) < k) {
                int res = 0;
                // 分割为字符串数组
                for (String t : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        // 最終返回不包含出現次数小于K的String长度即可
        return s.length();
    }

    private int extracted(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        // 判断每个班字符出现的次数
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            // 找到分割的字符 ch, 出现次数小于 < k
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0)
            return r - l + 1;

        int i = l;
        int ret = 0;
        while (i <= r) {
            // 找到起始的字符
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r)
                break;
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }
}
// @lc code=end
