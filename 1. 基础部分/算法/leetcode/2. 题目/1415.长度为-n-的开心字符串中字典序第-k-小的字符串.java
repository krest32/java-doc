import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1415 lang=java
 *
 * [1415] 长度为 n 的开心字符串中字典序第 k 小的字符串
 */

// @lc code=start
class Solution {
    // 记录长度为n的所有开心字符串
    List<String> listres = new ArrayList<>();

    public String getHappyString(int n, int k) {

        char[] num = { 'a', 'b', 'c' };
        dfs(num, "", n);

        int len = listres.size();
        if (k > len) {
            return "";
        } else {
            return listres.get(k - 1);
        }
    }

    private void dfs(char[] num, String s, int n) {

        int len = s.length();
        if (len == n) {
            // 如果为n则构成了一个完整的开心字符串，加入listres列表中
            listres.add(s);
            return;
        }

        for (int i = 0; i < num.length; i++) {
            // 如果是空串s s.charAt(len-1)越界
            if (s.equals("") || s.charAt(len - 1) != num[i]) {
                // 像这种字符串的添加回溯的话，
                // 不用Stringbuilder，用 s + "" 就好 无需减了
                dfs(num, s + num[i], n);
            }
        }
    }
}
// @lc code=end
