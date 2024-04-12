package problem.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc150EvalRPN {

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    deque.push(deque.pop() + deque.pop());
                    break;
                }
                case "-": {
                    Integer sub = deque.pop();
                    deque.push(deque.pop() - sub);
                    break;
                }
                case "*": {
                    deque.push(deque.pop() * deque.pop());
                    break;
                }
                case "/": {
                    Integer div = deque.pop();
                    deque.push(deque.pop() / div);
                    break;
                }
                default: {
                    deque.push(Integer.parseInt(token));
                }
            }
        }
        return deque.pop();
    }
}
