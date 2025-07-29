import java.security.KeyStore.Entry;
import java.util.*;

public class Main {
  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void rotateArray(int[] nums, int index) {
    // List<Integer> result = new ArrayList<>();
    int first = nums[index];
    for (int i = index; i < nums.length - 1; i++) {
      nums[i] = nums[i + 1];
    }
    nums[nums.length - 1] = first;
    // for(int i=0; i< nums.length; i++){
    // result.add(nums[i]);
    // System.out.print(nums[i] + " ");
    // }
    // return result;
  }

  public static void unionArray(int[] nums1, int[] nums2) {
    List<Integer> ls = new ArrayList<>();
    // HashMap<Integer> map = new HashMap<>();
    int i = 0;
    int j = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] <= nums2[j]) {
        ls.add(nums1[i++]);
        while (i < nums1.length && nums1[i] == nums1[i - 1])
          i++;
        while (j < nums2.length && nums2[j] == nums1[i - 1])
          j++;

      } else {
        ls.add(nums2[j++]);
        while (j < nums2.length && nums2[j] == nums2[j - 1])
          j++;
        while (i < nums1.length && nums1[i] == nums2[j - 1])
          i++;
      }
    }
    while (i < nums1.length) {
      ls.add(nums1[i++]);
    }
    while (j < nums2.length) {
      ls.add(nums2[j++]);
    }
    for (Integer it : ls) {
      System.out.print(it + " ");
    }
  }

  public static void checkSubarraySum(int[] nums, int k) {
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        System.out.println("sum  = " + sum + " k = " + k);
        if (sum != 0 && sum % k == 0) {
          System.out.println("sum 1 = " + sum + " k = " + k);
          // return true;
        }
      }
    }
    // return false;
  }

  public static int count1sBit(int n) {
    int count = 0;
    while (n > 0) {
      if (n % 2 == 1) {
        count++;
      }
      n = n / 2;
    }
    return count;
  }
public static void combinationSumuniue(int[] arr,int index, int target, List<Integer> ls, List<List<Integer>> ans){
   // 
    if(target == 0){
      System.out.print(ls);
    }
   for(int i = index; i<arr.length; i++){
    if(i != index && arr[i]== arr[i-1]) continue;
    if(arr[i] > target) break;
    ls.add(arr[i]);
    combinationSumuniue(arr, i+1, target-arr[i], ls, ans);
    ls.remove(ls.size()-1);
   }

}
public static void countGood(int[] nums, int k) {
  int numberOfPair = 0; // to track number of pairs
  int subArray = 0; // to track the number of subarrays
  HashMap<Integer, Integer> map = new HashMap<>();
  int start = 0;
  int end = 0;
  
  while (end < nums.length) {
      // Add the current number to the frequency map
      map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
      
      // Check if the current number's count is even (which forms a pair)
      if (map.get(nums[end]) % 2 == 0) {
          numberOfPair++;
      }
      
      // When we have at least 'k' pairs, count subarrays
      while (numberOfPair >= k) {
          // Count this subarray
          subArray += (nums.length - end);
          
          // Try to shrink the window from the left
          map.put(nums[start], map.get(nums[start]) - 1);
          if (map.get(nums[start]) % 2 == 1) {
              numberOfPair--;
          }
          start++;
      }
      
      end++;
  }
  
  // Output the result
  System.out.println("subarray = " + subArray);
}public static void main(String[] args) {
    int[] arr = {2,1,3,1,2,2,3,3,2,2,1,1,1,3,1};
    countGood(arr, 11);
    System.out.println();

    int[][] matrix = {{0,4,1},{9, 3, 7},{9,0,1}};
    Arrays.sort(arr);
    for(int[] row : matrix){
      Arrays.sort(row);
    }
    System.out.println(Arrays.deepToString(matrix));

  }

}

// public static void inorder(TreeNode root){
//   /*
//    * Logic remember L-P-R
//    * go left -> print -> go right
//    * edge case : if root are null return
//    */
//   if(root == null) return;
//   inorder(root.left);
//   System.out.print(root.value +" ");
//   inorder(root.right);
// }
// public static void postorder(TreeNode root){
//   /*
//    * Logic remember L-R-P
//    *  go left -> go right -> print root
//    * edge case : if root are null return
//    */
//   if(root == null) return;
//   postorder(root.left);
//   postorder(root.right);
//   System.out.print(root.value +" ");
// }
