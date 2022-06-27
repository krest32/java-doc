import java.security.acl.Owner;

/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        // 模拟
        return extracted(str);

        // return owner1(str);

    }

    private int owner1(String str) {
        char[] charArr = str.toCharArray();
        int len = charArr.length;
        int index = 0;
        while (index < len && charArr[index] == ' ') {
            index++;
        }
        if (index == len) {
            return 0;
        }
        int sign = 1;
        if (charArr[index] == '-') {
            sign = -1;
            index++;
        } else if (charArr[index] == '+') {
            index++;
        }
        int ret = 0;
        while (index < len) {
            char curChar = charArr[index];
            // 处理逻辑
            // 如果当前字符不是数字则跳出循环
            if (curChar > '9' || curChar < '0') {
                break;
            }
            if (ret > Integer.MAX_VALUE / 10
                    || (ret == Integer.MAX_VALUE / 10
                            && (curChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (ret < Integer.MIN_VALUE / 10
                    || (ret == Integer.MIN_VALUE / 10
                            && (curChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            ret = ret * 10 + sign * (curChar - '0');
            index++;
        }

        return ret;
    }

    /**
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 49.97 % of java submissions (41 MB)
     * 
     * @param str
     * @return
     */
    private int extracted(String str) {
        int len = str.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = str.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 " "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }
        // 4、将后续出现的数字字符进行转换
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }
            if (res > Integer.MAX_VALUE / 10
                    || (res == Integer.MAX_VALUE / 10
                            && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10
                    || (res == Integer.MIN_VALUE / 10
                            && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }
}
// @lc code=end
