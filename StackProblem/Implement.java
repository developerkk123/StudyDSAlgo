package StackProblem;

//problem statement: implement stack using array
class MyStack{
    // push implementation
    //pop implementation
    // size 
    // peek 
    // top 
    int size =1000;
    int[] arr = new int[size];
    int top = -1; // for trace
    void push(int x){
        top++;
        arr[top] = x;
    }
    int pop(){
        int x = arr[top];
        top--;
        return x;
    }
    int size(){
        return top+1;
    }
    boolean isEmpty(){
        return top == -1;
    }
}
class MyQueue{
    int start=-1, end=-1, size=1000;
    int[] arr = new int[size];
    void push(int x){
        if( end == -1){
            end++;
            start++;
        }
        end++;
        arr[end] = x;
    }
    int pop(){
        if(start == -1){
            System.out.println("queue is empty");
        }
        int x = arr[start];
        start++;
        return x;

    }
    int size(){
        return end-start;
    }
    boolean isEmpty(){
        return start == end;
    }
    int peek(){
        return arr[start];
    }
}
public class Implement {
    public static void main(String[] args) {
        MyQueue s = new MyQueue();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        System.out.println(s.pop());
        System.out.println(s.size());
    }
}
