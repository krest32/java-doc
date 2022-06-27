import java.util.Set;

/*
 * @lc app=leetcode.cn id=849 lang=java
 *
 * [849] 到最近的人的最大距离
 */

// @lc code=start
class Solution {
    public int maxDistToClosest(int[] seats) {
        // 滑动窗口 但是实现想法有些笨，不推荐
        // return extracted(seats);

        // 双指针
        return extracted2(seats);
    }

    /**
     * 81/81 cases passed (2 ms)
     * Your runtime beats 90 % of java submissions
     * Your memory usage beats 41.61 % of java submissions (43.3 MB)
     * 
     * 使用 prev 记录 i 最左边第一个有人的位置，
     * future 记录 i 最右边第一个有人的位置。
     * 
     * 座位 i 到最近的人的距离为 min(i - prev, future - i)。
     * 另外有一种特殊情况，
     * 1. 如果座位 i 左边没有人，则认为到左边第一个人的距离是无限大，
     * 2. 右边同理。
     * 
     * @param seats
     * @return
     */
    private int extracted2(int[] seats) {
        int len = seats.length;
        int prev = -1, future = 0;
        int ans = 0;

        for (int i = 0; i < len; ++i) {
            if (seats[i] == 1) {
                prev = i;
            } else {
                while (future < len && seats[future] == 0 || future < i)
                    future++;

                int left = prev == -1 ? len : i - prev;
                int right = future == len ? len : future - i;
                ans = Math.max(ans, Math.min(left, right));
            }
        }

        return ans;
    }

    /**
     * 81/81 cases passed (1 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 5.16 % of java submissions (43.8 MB)
     * 
     * @param seats
     * @return
     */
    private int extracted(int[] seats) {
        int max0 = 0;
        int cnt0 = 0;
        int start = 0;
        int stop = 0;
        int len = seats.length;
        int idx = 0;
        int seat = 0;
        while (idx < len) {
            if (seats[idx] == 0) {
                cnt0++;
                if (cnt0 == 1) {
                    start = idx;
                }
                idx++;
                // 记录当前节点的
                while (idx < len && seats[idx] == 0) {
                    cnt0++;
                    idx++;
                }
                if (idx > 0) {
                    stop = idx - 1;
                }
                if (cnt0 > max0) {
                    // 开始指定当前区域内的座位
                    if (stop == 0) {
                        seat = 0;
                    } else if (stop == len - 1) {
                        seat = stop;
                    } else {
                        if (start == 0) {
                            seat = 0;
                        } else {
                            seat = (start + stop) / 2;
                        }
                    }
                    max0 = Math.max(cnt0, max0);
                }
            } else {
                cnt0 = 0;
                idx++;
            }
        }

        int leftdis = 0;
        int leftSeat = seat;
        while (leftSeat >= 0 && seats[leftSeat] == 0) {
            leftSeat--;
            leftdis++;
        }

        int rightdis = 0;
        int rightSeat = seat;
        while (rightSeat < len && seats[rightSeat] == 0) {
            rightSeat++;
            rightdis++;
        }

        int max = leftdis == 0 ? rightdis
                : rightdis == 0 ? leftdis
                        : Math.min(leftdis, rightdis);
        if (seats[0] == 0) {
            leftdis = 0;
            int i = 0;
            while (i < len && seats[i] == 0) {
                leftdis++;
                i++;
            }
            max = Math.max(leftdis, max);
        }

        if (seats[len - 1] == 0) {
            rightdis = 0;
            int i = len - 1;
            while (i >= 0 && seats[i] == 0) {
                rightdis++;
                i--;
            }
            max = Math.max(rightdis, max);
        }

        return max;
    }
}
// @lc code=end
