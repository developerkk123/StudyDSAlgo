package ArrayProblem;

import java.util.HashMap;

public class SubArrayWithZeroSum {
    public static void maxLengthSubarrayWithZeroSum(int[] nums){

        // declare hashMap to store prefix sum and index
        // if prefix sum is same found means bich m kuchh ase element mile
        // jo apas m cut hue honge tabhi adding m koi effect nahi hue;
        // arr = {1,2,-2}
        // i=0; sum =1;
        // i=1; sum = 3;
        //i=2; sum = 1; // now see sum become 1 mean isse pahle 2, and -2 aaye
        // jiska effect kuchh nahi hua sum p; yahi wo sum array hai [2,-2]

        HashMap<Integer, Integer> map = new HashMap<>();

        int maxLength =0;
        int prefixSum =0;
        for(int i = 0; i< nums.length; i++){
           prefixSum = prefixSum + nums[i];
           if(prefixSum ==0){
             maxLength = i+1;
           }else{
            if(map.get(prefixSum) != null){// check prefix prefixSum in map
                maxLength = Math.max(maxLength, i-map.get(prefixSum));
            }else{
                map.put(prefixSum,i);
            }
           }
        }
        System.out.println("maxLength = "+ maxLength);
      //  return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {9, -3, 3, -1, 6, -5};
        maxLengthSubarrayWithZeroSum(nums);
    }
}
