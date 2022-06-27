import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784]
 */

// @lc code=start
class Solution {
    public List<String> letterCasePermutation(String s) {
        // 模拟 + list动态扩容
        // return extracted(s);

        // 1
        return test(s);
    }

    private List<String> test(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());
        for (char ch : s.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(ch)) {
                for (int i = 0; i < n; i++) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toUpperCase(ch));
                    ans.get(i + n).append(Character.toLowerCase(ch));
                }
            } else {
                for (int i = 0; i < n; i++) {
                    ans.get(i).append(ch);
                }
            }
        }
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++) {
            ret.add(ans.get(i).toString());
        }

        return ret;
    }

    private List<String> extracted(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());
        for (char c : s.toCharArray()) {
            int n = ans.size();
            // 如果当前的字符是字母，执行如下操作
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; i++) {
                    // 对于 ans 进行一次扩容
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n + i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; i++) {
                    ans.get(i).append(c);
                }
            }
        }
        List<String> finals = new ArrayList<>();
        for (StringBuilder sb : ans) {
            finals.add(sb.toString());
        }
        return finals;
    }
}
// @lc code=end
