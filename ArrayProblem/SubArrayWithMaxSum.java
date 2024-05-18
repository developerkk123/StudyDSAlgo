package ArrayProblem;

public class SubArrayWithMaxSum {
    //method 1 with O(n*n*n) time complexity
    public static void maxProductSubArray(int[] nums){
       int max = -10000;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length;j++){
                int product=1;
                for(int k=i; k<=j; k++){// sub array are [i->j]
                    product = product*nums[k];
                }
                max = Math.max(max, product);
            }
        }
        System.out.println("max = "+ max);
    }
     //method 1 with O(n) time complexity
     public static void maxProductSubArray2(int[] nums){
        int n = nums.length;
        int max = -10000;
        int prefixSum=1;// checking
        int suffixSum = 1;
        for(int i=0;i<nums.length; i++){
            if(prefixSum == 0) prefixSum =1;
            if(suffixSum == 0) suffixSum =1;

            // multiply pre and post
            prefixSum = prefixSum*nums[i];
            suffixSum = suffixSum*nums[n-i-1];
            max = Math.max(max, Math.max(prefixSum, suffixSum));
        }
         System.out.println("max = "+ max);
     }
    public static void main(String[] args) {
        int[] nums = {1,2,-3,0,-4,-5};
        maxProductSubArray2(nums);
    }
}
