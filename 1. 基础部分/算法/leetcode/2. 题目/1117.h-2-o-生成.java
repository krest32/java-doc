/*
 * @lc app=leetcode.cn id=1117 lang=java
 *
 * [1117] H2O 生成
 */

// @lc code=start
class H2O {

    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
    }
}
// @lc code=end

