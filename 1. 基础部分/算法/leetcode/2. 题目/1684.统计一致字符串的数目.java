import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1684 lang=java
 *
 * [1684] 统计一致字符串的数目
 */

// @lc code=start
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // 哈希
        return extracted(allowed, words);

        // 计数数组代替Set
        // return extracted2(allowed, words);

    }

    /**
     * 74/74 cases passed (6 ms)
     * Your runtime beats 83.89 % of java submissions
     * Your memory usage beats 35.08 % of java submissions (42.2 MB)
     * 
     * @param allowed
     * @param words
     * @return
     */
    private int extracted2(String allowed, String[] words) {
        int[] arr = new int[26];
        for (char ch : allowed.toCharArray()) {
            arr[ch - 'a']++;
        }
        int count = words.length;
        for (String str : words) {
            for (char ch : str.toCharArray()) {
                if (arr[ch - 'a'] == 0) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 74/74 cases passed (14 ms)
     * Your runtime beats 39.07 % of java submissions
     * Your memory usage beats 28.54 % of java submissions (42.3 MB)
     * 
     * @param allowed
     * @param words
     * @return
     */
    private int extracted(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            set.add(ch);
        }

        int count = words.length;
        for (String str : words) {
            for (char ch : str.toCharArray()) {
                if (!set.contains(ch)) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}
// @lc code=end
