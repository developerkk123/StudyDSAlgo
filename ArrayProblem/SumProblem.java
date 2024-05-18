package ArrayProblem;

import java.util.Arrays;
import java.util.HashSet;

public class SumProblem {
    //method 1 brute force method
    public static void findTripletEqualToZero1(int[] nums){
        // nums[a]+nums[b]+nums[c] = 0
        //a,b,c are distinct index in array
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1; k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        System.out.println("elements = "+ nums[i]+" "+nums[j]+" "+nums[k]+" ");
                    }
                }
            }
        }
    }
    //method 2 reduce one loop
    // use set store unique triplet

    public static void findTripletEqualToZero2(int[] nums){
        // nums[a]+nums[b]+nums[c] = 0
        //a,b,c are distinct index in array
        // use HashSet to store third number
        
        for(int i=0;i<nums.length-2;i++){
            // for each iteration set will be reset to empty
            // for better understanding dry run code on copy
            HashSet<Integer> set = new HashSet<>();
            for(int j=i+1;j<nums.length-1;j++){
                int third = -(nums[i]+nums[j]);
                if(set.contains(third)){
                    System.out.println("elements = "+ nums[i] +" "+ nums[j]+" "+ third);
                }
                set.add(nums[j]);
            }
        }
    }
    //method 3 optimal approach reduce one more for loop
    public static void findTripletEqualToZero3(int[] nums){
        // first sort array and use 3 pointer to find solution
        // in this method we will not use space complexity
        // like in method 2
        // fix one pointer and move 2 pointer to find sum =0;

        Arrays.sort(nums);
        for(int i=0; i<nums.length;i++){
            int j = i+1;
            int k = nums.length-1;
            // remove duplicates
            if(i!=0 && nums[i] == nums[i-1]) continue;
          //  int sum = nums[i]+nums[j]+nums[k];
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum > 0){
                    k--;
                }else if(sum < 0){
                    j++;
                }else{
                    System.out.println("elements = "+ nums[i] +" "+ nums[j]+" "+ nums[k]);
                    k--;
                    j++;
                    // skip duplicates and move pointer
                    while(j < k && nums[k] == nums[k+1]) k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        findTripletEqualToZero2(nums);
    }
}
