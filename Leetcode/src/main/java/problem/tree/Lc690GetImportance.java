package problem.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Lc690GetImportance {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(map, id);
    }


    int dfs(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        if (Objects.isNull(employee.subordinates) || employee.subordinates.isEmpty()) {
            return employee.importance;
        }
        int sum = employee.importance;
        for (Integer subordinate : employee.subordinates) {
            sum += dfs(map, subordinate);
        }
        return sum;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

}
