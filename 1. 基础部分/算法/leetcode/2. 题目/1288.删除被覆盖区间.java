import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1288 lang=java
 *
 * [1288] 删除被覆盖区间
 */

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
        });
        int count = 0;
        int end, prev_end = 0;
        for(int[] cur : intervals){
            end = cur[1];
            if(prev_end<end){
                ++ count;
                prev_end = end;
            }
        }
        return count;
    }   
}
// @lc code=end
