import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1797 lang=java
 *
 * [1797] 设计一个验证系统
 */

// @lc code=start
class AuthenticationManager {
    // 设置过期时间
    private int timeToLive;

    // 一个本地缓存，记录颁发的Id
    List<String> idList = new ArrayList<>();
    List<Integer> timeList = new ArrayList<>();
    // 存储id的最后一次更新的时间
    private final HashMap<String, Integer> map = new HashMap<>();
    // 表示上一次查询未过时验证码时，第一个未过时的验证码在列表中的索引
    int start = 0;

    /**
     * 设置有效时间
     * 
     * @param timeToLive
     */
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    /**
     * 将新的 id 与 时间记录到 系统当中
     * @param tokenId
     * @param currentTime
     */
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
        idList.add(tokenId);
        timeList.add(currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            // 若该id存在且未过时，则更新map并给列表添加记录
            if (map.get(tokenId) > currentTime - timeToLive) {
                map.put(tokenId, currentTime);
                idList.add(tokenId);
                timeList.add(currentTime);
            }
        }
    }

    // 记录未过期的 Tokens
    public int countUnexpiredTokens(int currentTime) {
        int n = idList.size();
        int i = start;
        for (; i < n; i++) {
            String id = idList.get(i);
            Integer time = timeList.get(i);
            // 遇到没超时的记录就停止遍历
            if (time > currentTime - timeToLive)
                break;
            // 如果这一id的最后一次更新时间和该次记录的时间相同，则说明这一id已经过时
            if (map.get(id).equals(time)) {
                map.remove(id);
            }
        }
        // 因为下一次时间肯定不早于这次的时间，所以下一次查询从start开始即可
        start = i;
        return map.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
// @lc code=end
