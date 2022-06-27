import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=2260 lang=java
 *
 * [2260] 必须拿起的最小连续卡牌数
 */

// @lc code=start
class Solution {
    public int minimumCardPickup(int[] cards) {
        // 暴力 -> 超时
        // return extracted(cards);

        // hash
        // return extracted2(cards);

        // 优化 hash map -> 最优解
        return extracted3(cards);
    }

    /**
     * 80/80 cases passed (44 ms)
     * Your runtime beats 44.68 % of java submissions
     * Your memory usage beats 36.41 % of java submissions (59.5 MB)
     * 
     * @param cards
     * @return
     */
    private int extracted3(int[] cards) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            if (!map.containsKey(cards[i])) {
                map.put(cards[i], i);
            } else {
                int dist = i - map.get(cards[i]) + 1;// 两个重复元素的最短距离
                ans = Math.min(dist, ans);// 更新最短距离
                map.put(cards[i], i);// 更新map的value
            }

        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 80/80 cases passed (68 ms)
     * Your runtime beats 11.42 % of java submissions
     * Your memory usage beats 6.56 % of java submissions (66.7 MB)
     * 
     * @param cards
     * @return
     */
    private int extracted2(int[] cards) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            List<Integer> list = map.getOrDefault(cards[i], new ArrayList<>());
            list.add(i);
            map.put(cards[i], list);
        }

        int ans = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> tempList = entry.getValue();
            if (tempList.size() <= 1) {
                continue;
            } else {
                for (int i = 1; i < tempList.size(); i++) {
                    int dis = tempList.get(i) - tempList.get(i - 1) + 1;
                    if (ans == -1) {
                        ans = dis;
                    } else {
                        ans = Math.min(ans, dis);
                    }
                }
            }
        }
        return ans;
    }

    /**
     * Time Limit Exceeded
     * 61/80 cases passed (N/A)
     * 
     * @param cards
     * @return
     */
    private int extracted(int[] cards) {
        int ans = -1;
        int len = cards.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (cards[i] == cards[j]) {
                    int curDis = j - i + 1;
                    if (ans == -1) {
                        ans = curDis;
                    } else {
                        ans = Math.min(ans, curDis);
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end
