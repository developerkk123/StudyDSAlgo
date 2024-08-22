package Math;
import java.util.*;

public class SubsetSum {
    public static void subsetSumRecur(int[] nums,int sum, int index, List<Integer> subset){
        if(index == nums.length){
            subset.add(sum);
            return;
        }
        // pic element and add in sum
        subsetSumRecur(nums, sum+nums[index], index+1, subset);

        // not pic and sum remain as it is
        subsetSumRecur(nums, sum, index+1, subset);
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        List<Integer> subset = new ArrayList<>();
        subsetSumRecur(nums, 0, 0, subset);
        System.out.println(subset);
    }
}
