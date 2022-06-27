import javafx.scene.shape.CubicCurve;

/*
 * @lc app=leetcode.cn id=1262 lang=java
 *
 * [1262] 可被三整除的最大和
 */

// @lc code=start
class Solution {
    // 进行滚动求和
    public int maxSumDivThree(int[] nums) {
        // mod0为模==0的最大累加和，mod1模==1的最大累加和，mod2模==2的最大累加和
        int mod0 = 0, mod1 = 0, mod2 = 0;
        int cur0 = 0, cur1 = 0, cur2 = 0;
        for (int num : nums) {
            int mod = num % 3;
            switch (mod) {
                case 0:
                    // cur1
                    cur0 = mod0 + num;
                    cur1 = mod1 == 0 ? mod1 : mod1 + num;
                    cur2 = mod2 == 0 ? mod2 : mod2 + num;
                    break;
                case 1:
                    cur0 = mod2 == 0 ? mod0 : Math.max(mod0, mod2 + num);
                    cur1 = Math.max(mod1, mod0 + num);
                    cur2 = mod1 == 0 ? mod2 : Math.max(mod2, mod1 + num);
                    break;
                case 2:
                    cur0 = mod1 == 0 ? mod0 : Math.max(mod0, mod1 + num);
                    cur1 = mod2 == 0 ? mod1 : Math.max(mod1, mod2 + num);
                    cur2 = Math.max(mod2, mod0 + num);
                    break;
                default:
            }
            mod0 = cur0;
            mod1 = cur1;
            mod2 = cur2;
        }
        return mod0;
    }
}
// @lc code=end
