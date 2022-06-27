import java.io.CharArrayReader;

/*
 * @lc app=leetcode.cn id=1576 lang=java
 *
 * [1576] 替换所有的问号
 */

// @lc code=start
class Solution {
    public String modifyString(String s) {
        // 模拟
        // return extracted(s);

        // 1
        return test(s);
    }

    private String test(String s) {
        int n = s.length();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (charArr[i] == '?') {
                for (char re = 'a'; re <= 'c'; re++) {
                    if ((i > 0 && charArr[i - 1] == re) || (i < n - 1 && charArr[i + 1] == re)) {
                        continue;
                    }
                    charArr[i] = re;
                    break;
                }
            }
        }
        return new String(charArr);
    }

    private String extracted(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (arr[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ch++) {
                    if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
                        continue;
                    }
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }
}
// @lc code=end
