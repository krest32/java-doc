import java.util.Stack;

/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    String src;
    int ptr;

    public String decodeString(String s) {
        // 1. 递归
        return extracted(s);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 83.21 % of java submissions (39.1 MB)
     * 
     * @param s
     * @return
     */
    private String extracted(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    // 递归解码
    public String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']')
            return "";
        char cur = src.charAt(ptr);
        StringBuilder ret = new StringBuilder();
        if (Character.isDigit(cur)) {
            int repTime = getDigits();
            // 过滤左括号
            ptr++;
            // 解析 String
            String str = getString();
            // 过滤右括号
            ptr++;
            // 构造字符串
            while (repTime-- > 0)
                ret.append(str);
        } else if (Character.isLetter(cur))
            ret.append(src.charAt(ptr++));
        return ret.append(getString()).toString();
    }

    public int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr)))
            ret = ret * 10 + src.charAt(ptr++) - '0';
        return ret;
    }
}
// @lc code=end
