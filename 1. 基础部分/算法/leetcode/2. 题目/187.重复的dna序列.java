import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        // 滑动窗口+哈希表
        return extracted(s);

    }

    private List<String> extracted(String s) {
        final int L = 10;
        List<String> ans = new ArrayList<String>();
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        int n = s.length();
        for (int i = 0; i <= n - L; ++i) {
            // 起始窗口
            String sub = s.substring(i, i + L);
            // 截取字符串进入到hash中
            cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
            // 判断并保存数据
            if (cnt.get(sub) == 2) {
                ans.add(sub);
            }
        }
        return ans;
    }
}
// @lc code=end
