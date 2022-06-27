import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 排序 如果身高相同，那么就按照另一个条件降序排序
        Arrays.sort(people, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            // person[1] 表示person要插入队列当中的位置
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
// @lc code=end
