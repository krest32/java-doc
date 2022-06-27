import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1177 lang=java
 *
 * [1177] 构建回文串检测
 */

// @lc code=start
class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        // 暴力法，超时
        // return extracted(s, queries);

        // 动态规划
        return extracted2(s, queries);
    }

    /**
     * 31/31 cases passed (59 ms)
     * Your runtime beats 13.28 % of java submissions
     * Your memory usage beats 23.43 % of java submissions (110.6 MB)
     * 
     * @param s
     * @param queries
     * @return
     */
    private List<Boolean> extracted2(String s, int[][] queries) {
        int n = s.length();
        // 记录 i 位置的，26个字符，每个字符的个数
        int[][] count = new int[n][26];

        count[0][s.charAt(0) - 'a']++;
        for (int i = 1; i < n; ++i) {
            count[i][s.charAt(i) - 'a']++;
            for (int j = 0; j < 26; ++j) {
                count[i][j] += count[i - 1][j];
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0], right = query[1], k = query[2];
            if (k >= right - left + 1) {
                res.add(true);
                continue;
            }
            int modify = 0;
            for (int i = 0; i < 26; ++i) {
                int p = left == 0 ? count[right][i] : count[right][i] - count[left - 1][i];
                if (p > 0) {
                    if (p % 2 == 1) {
                        modify++;
                    }
                }
            }
            if ((modify / 2 <= k) || modify == 0 || (modify == 1 && k == 0)) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    /**
     * Time Limit Exceeded
     * 29/31 cases passed (N/A)
     * 
     * @param s
     * @param queries
     * @return
     */
    private List<Boolean> extracted(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if (check(s, queries[i])) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    private boolean check(String s, int[] nums) {
        String tempStr = s.substring(nums[0], nums[1] + 1);
        if (tempStr.length() == 1) {
            return true;
        } else {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : tempStr.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            int cnt = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    cnt++;
                }
            }
            if (tempStr.length() % 2 == 0) {
                cnt /= 2;
                if (cnt > nums[2]) {
                    return false;
                }
                return true;
            } else {
                cnt--;
                cnt /= 2;
                if (cnt > nums[2]) {
                    return false;
                }
                return true;

            }
        }
    }
}
// @lc code=end
