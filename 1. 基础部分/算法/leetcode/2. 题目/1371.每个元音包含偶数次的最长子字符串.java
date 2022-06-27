import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1371 lang=java
 *
 * [1371] 每个元音包含偶数次的最长子字符串
 */

// @lc code=start
class Solution {

    List<Map<Character, Integer>> list = new ArrayList<>();

    public int findTheLongestSubstring(String s) {
        // 前缀和+状态压缩
        // return extracted2(s);

        // 暴力： 两个指针确认子字符串
        return extracted(s);
    }

    /**
     * 53/53 cases passed (12 ms)
     * Your runtime beats 71.17 % of java submissions
     * Your memory usage beats 27.4 % of java submissions (45.6 MB)
     * 
     * @param s
     * @return
     */
    private int extracted2(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }

    /**
     * 
     * 53/53 cases passed (1228 ms)
     * Your runtime beats 5.34 % of java submissions
     * Your memory usage beats 5.34 % of java submissions (220.2 MB)
     * 
     * @param s
     * @return
     */
    private int extracted(String s) {
        int len = s.length();
        int cur = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (i == 0) {
                if (isVol(ch)) {
                    Map<Character, Integer> map = new HashMap<>();
                    map.put(ch, 1);
                    list.add(map);
                } else {
                    cur = 1;
                    list.add(new HashMap<>());
                }
            } else {
                Map<Character, Integer> map = new HashMap<>(list.get(i - 1));
                if (isVol(ch))
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                else
                    cur = 1;
                list.add(map);
            }
        }
        for (int i = 0; i < len; i++) {
            // 需要从后向前遍历，否则会超时
            for (int j = len - 1; j > i; j--) {
                // 第一次剪枝
                if (cur > j - i + 1)
                    break;
                if (isDoubleStr(i, j))
                    cur = Math.max(cur, j - i + 1);
            }
        }
        return cur;
    }

    private boolean isDoubleStr(int i, int j) {
        int cura = 0, cure = 0, curi = 0, curo = 0, curu = 0;
        if (i > 0) {
            cura = list.get(j).getOrDefault('a', 0) - list.get(i - 1).getOrDefault('a', 0);
            cure = list.get(j).getOrDefault('e', 0) - list.get(i - 1).getOrDefault('e', 0);
            curi = list.get(j).getOrDefault('i', 0) - list.get(i - 1).getOrDefault('i', 0);
            curo = list.get(j).getOrDefault('o', 0) - list.get(i - 1).getOrDefault('o', 0);
            curu = list.get(j).getOrDefault('u', 0) - list.get(i - 1).getOrDefault('u', 0);
        } else {
            cura = list.get(j).getOrDefault('a', 0);
            cure = list.get(j).getOrDefault('e', 0);
            curi = list.get(j).getOrDefault('i', 0);
            curo = list.get(j).getOrDefault('o', 0);
            curu = list.get(j).getOrDefault('u', 0);
        }
        return cura % 2 == 0 && cure % 2 == 0 && curi % 2 == 0 && curo % 2 == 0 && curu % 2 == 0;
    }

    boolean isVol(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

}
// @lc code=end
