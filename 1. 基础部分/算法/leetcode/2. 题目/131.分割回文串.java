import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        // 回溯
        return extracted(s);
    }

    private List<List<String>> extracted(String s) {
        List<List<String>> ans = new ArrayList<>();
        backTracking(s, ans, new ArrayList<String>());
        return ans;
    }

    private void backTracking(String s,
            List<List<String>> ans,
            ArrayList<String> arr) {
        if (s.length() == 0) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (isPailndome(s, 0, i)) {
                    arr.add(s.substring(0, i + 1));
                    backTracking(s.substring(i + 1), ans, arr);
                    arr.remove(arr.size() - 1);
                }
            }
        }
    }

    private boolean isPailndome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
