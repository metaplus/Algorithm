package problem.search.dfs;

import java.util.*;

public class Lc690GetImportance {

    public int getImportance(List<Employee> employees, int id) {
        if (Objects.isNull(employees) || employees.isEmpty()) {
            return 0;
        }
        Map<Integer, Employee> map = new HashMap<>(employees.size());
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Deque<Employee> deque = new ArrayDeque<>();
        deque.add(map.get(id));
        int sum = 0;
        while (!deque.isEmpty()) {
            Employee poll = deque.poll();
            sum += poll.importance;
            if (Objects.isNull(poll.subordinates) || poll.subordinates.isEmpty()) {
                continue;
            }
            for (Integer subordinate : poll.subordinates) {
                deque.add(map.get(subordinate));
            }
        }
        return sum;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

}
