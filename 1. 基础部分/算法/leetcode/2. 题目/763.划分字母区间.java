import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        // 记录每个字符最终出现的位置
        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i), i);
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            // 获取得到字符的位置
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
// @lc code=end
