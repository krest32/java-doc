/*
 * @lc app=leetcode.cn id=423 lang=java
 *
 * [423] 从英文中重建数字
 */

// @lc code=start
class Solution {


    static String[] ss = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static int[] priority = new int[]{0, 8, 6, 3, 2, 7, 5, 9, 4, 1};

    public String originalDigits(String s) {
        int n = s.length();
        int[] cnts = new int[26];
        for (int i = 0; i < n; i++) cnts[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i : priority) {
            int k = Integer.MAX_VALUE;
            for (char c : ss[i].toCharArray()) k = Math.min(k, cnts[c - 'a']);
            for (char c : ss[i].toCharArray()) cnts[c - 'a'] -= k;
            while (k-- > 0) sb.append(i);
        }
        char[] cs = sb.toString().toCharArray();
        Arrays.sort(cs);
        return String.valueOf(cs);
    }
    // public String originalDigits(String s) {
        // Map<Character, Integer> c = new HashMap<Character, Integer>();
        // for (int i = 0; i < s.length(); ++i) {
        //     char ch = s.charAt(i);
        //     c.put(ch, c.getOrDefault(ch, 0) + 1);
        // }

        // int[] cnt = new int[10];
        // cnt[0] = c.getOrDefault('z', 0);
        // cnt[2] = c.getOrDefault('w', 0);
        // cnt[4] = c.getOrDefault('u', 0);
        // cnt[6] = c.getOrDefault('x', 0);
        // cnt[8] = c.getOrDefault('g', 0);

        // cnt[3] = c.getOrDefault('h', 0) - cnt[8];
        // cnt[5] = c.getOrDefault('f', 0) - cnt[4];
        // cnt[7] = c.getOrDefault('s', 0) - cnt[6];

        // cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        // cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

        // StringBuffer ans = new StringBuffer();
        // for (int i = 0; i < 10; ++i) {
        //     for (int j = 0; j < cnt[i]; ++j) {
        //         ans.append((char) (i + '0'));
        //     }
        // }
        // return ans.toString();

}
// @lc code=end

