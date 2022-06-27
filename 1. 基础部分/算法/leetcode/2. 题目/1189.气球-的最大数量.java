import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1189 lang=java
 *
 * [1189] “气球” 的最大数量
 */

// @lc code=start
class Solution {
    public int maxNumberOfBalloons(String text) {
        // 模拟 计数
        return extracted(text);

    }

    private int extracted(String text) {
        // 记录每个字符出现的次数
        int[] cnt = new int[5];
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'b':
                    cnt[0]++;
                    break;
                case 'a':
                    cnt[1]++;
                    break;
                case 'l':
                    cnt[2]++;
                    break;
                case 'o':
                    cnt[3]++;
                    break;
                case 'n':
                    cnt[4]++;
                    break;
                default:
            }
        }
        cnt[2] /= 2;
        cnt[3] /= 2;
        // 获取数组中的最小值
        return Arrays.stream(cnt).min().getAsInt();
    }
}
// @lc code=end
