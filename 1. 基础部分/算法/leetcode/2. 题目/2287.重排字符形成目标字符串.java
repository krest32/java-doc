import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=2287 lang=java
 *
 * [2287] 重排字符形成目标字符串
 */

// @lc code=start
class Solution {
    public int rearrangeCharacters(String s, String target) {
        // 使用hash结构存储字符出现次数
        return extracted(s, target);
    }

    /**
     * 115/115 cases passed (2 ms)
     * Your runtime beats 19.89 % of java submissions
     * Your memory usage beats 5.17 % of java submissions (40.1 MB)
     * 
     * @param s
     * @param target
     * @return
     */
    private int extracted(String s, String target) {
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> sourceMap = new HashMap<>();
        for (char ch : target.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s.toCharArray()) {
            sourceMap.put(ch, sourceMap.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            list.add(entry);
        }
        int ans = 0;
        while (true) {
            boolean flag = true;
            for (int i = 0; i < list.size(); i++) {
                char ch = list.get(i).getKey();
                int cnt = list.get(i).getValue();
                int sourceCnt = sourceMap.getOrDefault(ch, 0);
                if (sourceCnt >= cnt) {
                    int val = sourceCnt - cnt;
                    sourceMap.put(ch, val);
                } else {
                    flag = false;
                }
            }
            if (flag) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}
// @lc code=end
