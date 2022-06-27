/*
 * @lc app=leetcode.cn id=1472 lang=java
 *
 * [1472] 设计浏览器历史记录
 */

// @lc code=start
class BrowserHistory {
    Node page;
    Node temp = page;

    public BrowserHistory(String homepage) {
        page = new Node(homepage);
    }

    public void visit(String url) {
        Node newPage = new Node(url);
        newPage.next = null;
        page.next = newPage;
        newPage.pre = page;
        page = page.next;
    }

    public String back(int steps) {
        while (steps != 0) {
            if (page.pre == temp) {
                break;
            } else {
                page = page.pre;
                steps--;
            }
        }
        return page.str;
    }

    public String forward(int steps) {
        while (steps != 0) {
            if (page.next == null) {
                break;
            } else {
                page = page.next;
                steps--;
            }
        }
        return page.str;
    }
}

class Node {
    String str;
    Node pre;
    Node next;

    Node(String str) {
        this.str = str;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
// @lc code=end
