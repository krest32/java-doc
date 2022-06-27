import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1239 lang=java
 *
 * [1239] 串联字符串的最大长度
 */

// @lc code=start
class Solution {
    int maxLen = 0;

    public int maxLength(List<String> arr) {
        // 回溯
        return extracted(arr);
    }

    /**
     * Your runtime beats 46.77 % of java submissions
     * Your memory usage beats 27.85 % of java submissions (41 MB)
     * 
     * @param arr
     * @return
     */
    private int extracted(List<String> arr) {
        if (arr.size() == 0) {
            return maxLen;
        } else if (arr.size() == 1) {
            if (check(arr.get(0))) {
                return arr.get(0).length();
            } else {
                return 0;
            }
        }
        // 回溯
        backTracking(arr, new StringBuilder(), 0);
        return maxLen;
    }

    private void backTracking(List<String> arr,
            StringBuilder tempStr,
            int idx) {
        maxLen = Math.max(tempStr.length(), maxLen);

        for (int i = idx; i < arr.size(); i++) {
            if (checkTwoStr(tempStr.toString(), arr.get(i))) {
                tempStr.append(arr.get(i));
                backTracking(arr, tempStr, i + 1);
                tempStr.delete(tempStr.length() - arr.get(i).length(), tempStr.length());
            }
        }
    }

    boolean checkTwoStr(String A, String B) {
        int[] cnt = new int[26];
        for (int i = 0; i < A.length(); i++) {
            cnt[A.charAt(i) - 'a']++;
            if (cnt[A.charAt(i) - 'a'] > 1) {
                return false;
            }
        }
        for (int i = 0; i < B.length(); i++) {
            cnt[B.charAt(i) - 'a']++;
            if (cnt[B.charAt(i) - 'a'] > 1) {
                return false;
            }
        }
        return true;
    }

    // 判断字符串中没有重复的字符
    boolean check(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (!set.add(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
