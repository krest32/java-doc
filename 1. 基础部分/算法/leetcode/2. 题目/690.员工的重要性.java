import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=690 lang=java
 *
 * [690] 员工的重要性
 */

// @lc code=start
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer,Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for(Employee employee : employees){
            map.put(employee.id, employee);
        }
        return dfs(id);
    }
    private int dfs(int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> subIds = employee.subordinates;
        for(int subId : subIds){
            total += dfs(subId);
        }
        return total;
    }
}
// @lc code=end

