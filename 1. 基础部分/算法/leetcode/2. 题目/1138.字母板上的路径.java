/*
 * @lc app=leetcode.cn id=1138 lang=java
 *
 * [1138] 字母板上的路径
 */

// @lc code=start
class Solution {
    public String alphabetBoardPath(String target) {
        // 记录当前所在位置
        int x = 0, y = 0;
        // 用来构建返回值
        StringBuilder builder = new StringBuilder();
        for (char c : target.toCharArray()) {
            // 找到新的 (nx, ny) 坐标位置
            int nx = (c - 'a') / 5, ny = (c - 'a') % 5;
            // 如果新的位置在当前位置的【上方】，那么需要先往上走，下同
            if (nx < x)
                builder.append("U".repeat(x - nx));
            if (ny < y)
                builder.append("L".repeat(y - ny));
            // 如果新的位置在当前位置的【右方】，那么需要先往右走，下同
            if (ny > y)
                builder.append("R".repeat(ny - y));
            if (nx > x)
                builder.append("D".repeat(nx - x));
            // 执行字符记录操作：！
            builder.append("!");
            // 更新当前坐标位置
            x = nx;
            y = ny;
        }
        return builder.toString();
    }
}
// @lc code=end
