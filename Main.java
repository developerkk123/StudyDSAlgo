import java.security.KeyStore.Entry;
import java.util.*;

public class Main {
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void rotateArray(int[] nums, int index){
     // List<Integer> result = new ArrayList<>();
      int first= nums[index];
      for(int i = index; i < nums.length-1; i++){
        nums[i] = nums[i+1];
      }
      nums[nums.length-1] = first;
      // for(int i=0; i< nums.length; i++){
      //   result.add(nums[i]);
      //   System.out.print(nums[i] + " ");
      // }
    //  return result;
    }
    public static void unionArray(int[] nums1, int[] nums2) {
       List<Integer> ls = new ArrayList<>();
     //  HashMap<Integer> map = new HashMap<>();
       int i=0;
       int j=0;
       while(i < nums1.length && j< nums2.length){
        if(nums1[i] <= nums2[j]){
            ls.add(nums1[i++]);
            while(i<nums1.length && nums1[i] == nums1[i-1]) i++;
            while(j < nums2.length && nums2[j] == nums1[i-1]) j++;

        }else{
            ls.add(nums2[j++]);
            while(j < nums2.length && nums2[j] == nums2[j-1]) j++;
            while(i<nums1.length && nums1[i] == nums2[j-1]) i++;
        }
       }
       while (i < nums1.length) {
        ls.add(nums1[i++]);
       }
       while (j < nums2.length) {
         ls.add(nums2[j++]);
       }
       for(Integer it: ls){
        System.out.print(it+" ");
       }
    }
    public static void checkSubarraySum(int[] nums, int k) {
      for(int i=0; i< nums.length; i++){
          int sum = 0;
          for(int j =i; j< nums.length; j++){
              sum +=  nums[j];
              System.out.println("sum  = "+ sum + " k = "+ k);
              if( sum != 0 && sum % k == 0){
                System.out.println("sum 1 = "+ sum + " k = "+ k);
                 // return true;
              }
          }
      }
      //return false;
  }
  public static int count1sBit(int n){
    int count =0;
    while(n > 0){
      if(n%2 == 1){
        count++;
      }
      n = n/2;
    }
    return count;
  }
    public static void main(String[] args) {
     // HashMap<String, Integer> map = new HashMap<>();
     StringBuilder ans = new StringBuilder();
      String num1 = "11";
      String num2 = "23";
      int i = num1.length()-1;
      int j = num2.length()-1;
      int rem = 0;
      while(i >= 0 && j>=0){
          int n1 = num1.charAt(i)-'0';
          int n2 = num2.charAt(j)-'0';
         int sum =  n1 + n2 + rem;
        //  System.out.println(sum);
         // rem = (n1+n2)%10;
          ans.append(sum%10);
          rem = sum/10;
          i--;j--;
      }

     System.out.println(ans.toString());
    }
}
