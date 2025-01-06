package StackProblem;
import java.util.*;

public class SortStack {
    // problem statement:sort stack using recursion
    // TC: ?
    // SC: ?
    public static void sortedInsert(Stack<Integer> s, int x){
        // base case if stack is empty or x is greater then top element
        // push x in stack and return
        if(s.isEmpty() || x > s.peek()){
            s.push(x);
            return;
        }
        // if top is greater then x pop and recur
        int temp = s.pop();
        sortedInsert(s, x);

        //push back pop element
        s.push(temp);
    }
    public static void sortStack(Stack<Integer> s){
        if(!s.isEmpty()){
            int temp = s.pop();
            // System.out.println(temp+" temp");
            sortStack(s);
            sortedInsert(s, temp);

        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(5);
        stack.push(10);
        stack.push(1);
        sortStack(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop()+" ");
        }
    }
}
