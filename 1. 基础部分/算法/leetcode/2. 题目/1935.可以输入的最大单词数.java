import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1935 lang=java
 *
 * [1935] 可以输入的最大单词数
 */

// @lc code=start
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // 哈希
        return extracted(text, brokenLetters);
    }

    /**
     * Your runtime beats 56.53 % of java submissions
     * Your memory usage beats 43.75 % of java submissions (40.9 MB)
     * 
     * @param text
     * @param brokenLetters
     * @return
     */
    private int extracted(String text, String brokenLetters) {
        return extracted2(text, brokenLetters);
    }

    /**
     * Your runtime beats 56.53 % of java submissions
     * Your memory usage beats 43.75 % of java submissions (40.9 MB)
     * 
     * @param text
     * @param brokenLetters
     * @return
     */
    private int extracted2(String text, String brokenLetters) {
        int len2 = brokenLetters.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len2; i++) {
            set.add(brokenLetters.charAt(i));
        }

        String[] arr = text.split(" ");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            Iterator<Character> it = set.iterator();
            boolean flag = false;
            while (it.hasNext()) {
                char ch = it.next();
                if (word.indexOf(ch) >= 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end
