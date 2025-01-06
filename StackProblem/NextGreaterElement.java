package StackProblem;
import java.util.*;
public class NextGreaterElement {
    static int[] NGEFunction(int[] nums){
        int[] res = new int[nums.length];
        // define a stack for storing element in increasing order
        // look from right 
        // if stack is empty mean no NGE return -1
        // for nums[i] is stack element is less pop out those
        //Note: for circular i=2*n-1 and nums[i%n]
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for(int i=n-1; i>=0; i--){
            if(stack.isEmpty()){
                res[i] = -1;
            }else if(stack.peek() > nums[i]){
                res[i] = stack.peek();
            }else{
                while(!stack.isEmpty() && stack.peek() <= nums[i] ){
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
                
            }
            stack.push(nums[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,3,1,2,2,3,3,2,2,1,1,1,3,1};
        int[] nge = NGEFunction(arr);
        for(int i=0; i<nge.length; i++){
            System.out.print(nge[i] + " ");
        }
    }
}
