import java.util.HashMap;
import java.util.Map;

import entrty.Node;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            // 新建新的节点
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);

            // 复制head.next
            headNew.next = copyRandomList(head.next);
            // 复制 head.random
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
// @lc code=end
