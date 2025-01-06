package Math;
import java.util.*;
public class SubArrayPrint {
     // Recursive function to print subarrays
     // Recursive function to collect all subarrays
    static List<List<Integer>> printSubarray1(int[] nums, int start, int end, List<List<Integer>> ans, int sum) {
        // Base case: If the start index exceeds the array length, return the result
        if (start == nums.length) {
            System.out.println(sum+" sum");
            return ans;
        }

        // If end is within bounds, we add the subarray starting at 'start' and ending at 'end'
        if (end < nums.length) {
            // Create a sublist for the current subarray
            List<Integer> subarray = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                subarray.add(nums[i]);
            }
           // System.out.println("subraay = " + subarray);
           Collections.sort(subarray);
           sum+= subarray.get(subarray.size()-1) -subarray.get(0) ;
            ans.add(subarray); // Add the subarray to the answer list
            // Recurse by expanding the subarray with the next 'end' element
            return printSubarray1(nums, start, end + 1, ans, sum);
        } else {
            // If 'end' exceeds array length, move to the next 'start' index and reset 'end'
            return printSubarray1(nums, start + 1, start + 1, ans, sum);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,3,3};
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int sum=0;
        printSubarray1(nums, 0, 0, ans,sum);
        // Print all subarrays
            for (List<Integer> subarray : ans) {
                System.out.println(subarray);
            }
    }
}
