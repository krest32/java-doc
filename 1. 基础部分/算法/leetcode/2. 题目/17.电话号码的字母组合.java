import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {

    public List<String> letterCombinations(String digits) {
        // 回溯
        return extracted(digits);

    }

    private List<String> extracted(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        backTrack(res, phoneMap, digits, 0, new StringBuilder());
        return res;
    }

    private void backTrack(List<String> res,
            Map<Character, String> phoneMap,
            String digits,
            int k,
            StringBuilder temp) {
        if (k == digits.length()) {
            res.add(temp.toString());
        } else {
            String phoneStr = phoneMap.get(digits.charAt(k));
            for (int i = 0; i < phoneStr.length(); i++) {
                temp.append(phoneStr.charAt(i));
                backTrack(res, phoneMap, digits, k + 1, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

}
// @lc code=end
