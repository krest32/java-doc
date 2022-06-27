import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1710 lang=java
 *
 * [1710] 卡车上的最大单元数
 */

// @lc code=start
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // 模拟：根据每个箱子中的单位数量排序
        return extracted(boxTypes, truckSize);
    }

    private int extracted(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> (o2[1] - o1[1]));
        int ans = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            // 活期卡车中能够转入箱子的数量
            int num = Math.min(truckSize, boxTypes[i][0]);
            truckSize -= num;
            ans += num * boxTypes[i][1];
        }
        return ans;
    }
}
// @lc code=end
