package SlidingWindowProblem;

public class BasicApproach {
    // method 1
    static void slidingWindiow(int[] nums, int k){
        // first calculate the first window
        for(int i=0; i<k; i++){
            System.out.print(nums[i]+" ");
        }
        // calculate rest window
        for(int i=k; i<nums.length-k; i++){
            System.out.print(nums[]);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int k=3;
        slidingWindiow(nums, k);
    }
}
