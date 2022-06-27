import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1417 lang=java
 *
 * [1417] 重新格式化字符串
 */

// @lc code=start
class Solution {
    public String reformat(String s) {
        // 模拟
        return extracted(s);
    }

    /**
     * 302/302 cases passed (5 ms)
     * Your runtime beats 34.81 % of java submissions
     * Your memory usage beats 5.18 % of java submissions (42.3 MB)
     * 
     * @param s
     * @return
     */
    private String extracted(String s) {
        List<Character> charList = new ArrayList<>();
        List<Character> numList = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                numList.add(ch);
            } else {
                charList.add(ch);
            }
        }
        if (Math.abs(numList.size() - charList.size()) > 1) {
            return "";
        } else {
            if (numList.size() > charList.size()) {
                return genStr(numList, charList);
            } else {
                return genStr(charList, numList);
            }
        }
    }

    private String genStr(List<Character> numList, List<Character> charList) {
        StringBuilder ans = new StringBuilder();
        boolean flag = true;
        int idx1 = 0, idx2 = 0;
        while (idx1 < numList.size()) {
            if (flag) {
                ans.append(numList.get(idx1));
                idx1++;
            } else {
                ans.append(charList.get(idx2));
                idx2++;
            }
            flag = !flag;
        }
        if (idx2 < charList.size()) {
            ans.append(idx2);
        }

        return ans.toString();
    }
}
// @lc code=end
