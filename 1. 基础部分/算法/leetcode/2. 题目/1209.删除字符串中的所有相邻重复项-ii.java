import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1209 lang=java
 *
 * [1209] 删除字符串中的所有相邻重复项 II
 */

// @lc code=start
class Solution {
    String res;

    public String removeDuplicates(String s, int k) {
        // 暴力解法 -- > 超时
        // return extracted(s, k);

        // 暴力法 --> 超时
        // return extracted2(s, k);

        // 记忆法 最优 --> 在for循环的过程中修改索引值
        // return extracted3(s, k);

        // 栈 --> 也还可以
        return extracted4(s, k);
    }

    /**
     * Your runtime beats 36.19 % of java submissions
     * Your memory usage beats 57.1 % of java submissions (41.8 MB)
     * 
     * @param s
     * @param k
     * @return
     */
    private String extracted4(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.push(1);
            } else {
                int incremented = counts.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }

    /**
     * Your runtime beats 78.82 % of java submissions
     * Your memory usage beats 45.04 % of java submissions (41.9 MB)
     * 
     * @param s
     * @param k
     * @return
     */
    private String extracted3(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int count[] = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                if (count[i] == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }
        return sb.toString();
    }

    private String extracted2(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int length = -1;
        while (length != sb.length()) {
            length = sb.length();
            for (int i = 0, count = 1; i < sb.length(); ++i) {
                if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                    count = 1;
                } else if (++count == k) {
                    sb.delete(i - k + 1, i + 1);
                    break;
                }
            }
        }
        return sb.toString();
    }

    private String extracted(String s, int k) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] >= k) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < k; j++) {
                    temp.append((char) (i + 'a'));
                }
                list.add(temp.toString());
            }
        }

        // 判断是否存在
        if (list.size() > 0) {
            System.out.println(list.size());
            dfs(list, s);
        } else {
            return s;
        }

        return res.toString();
    }

    private void dfs(List<String> list, String str) {
        if (check(list, str)) {
            res = str;
            return;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (str.indexOf(list.get(i)) >= 0) {
                    String temp = buildStr(str, list.get(i));
                    dfs(list, temp);
                }
            }
        }
    }

    private boolean check(List<String> list, String str) {
        boolean flag = true;
        for (String temp : list) {
            if (str.indexOf(temp) >= 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    // 截取字符串
    private String buildStr(String s, String split) {
        StringBuilder res = new StringBuilder();
        int idx = s.indexOf(split);
        res.append(s.substring(0, idx)).append(s.substring(idx + split.length(), s.length()));
        return res.toString();
    }
}
// @lc code=end
