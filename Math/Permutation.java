package Math;
import java.util.ArrayList;
import java.util.List;

public class Permutation {
    //recursion call
    private static void reCurPermutation(int index, int[] nums, List<List<Integer>> ans){
        // if index reaches at last base case
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i: nums){
                temp.add(i);
            }
            ans.add(temp);
            return;
        }
        for(int i = index; i<nums.length;i++){
            swap(i, index, nums);
            reCurPermutation(index+1, nums, ans);
            swap(i, index, nums); // backtracking to get original string after recusrion completed
        }
    }
    private  static void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    // main function
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ls = new ArrayList<>();
        reCurPermutation(0, nums, ls);
        return ls;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        result = permute(nums);
        for(List<Integer> list: result){
            for(Integer n: list){
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }
}
