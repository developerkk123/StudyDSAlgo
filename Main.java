import java.util.*;

public class Main {
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
    public static void main(String[] args) {
      // in-place modification of array
        int[] arr = {1,1,2,3,4,4};
        int i=0;
        for(int j=1;j<arr.length;j++){
          if(arr[i]!=arr[j]){
            i++;
            arr[i]=arr[j];
          }
        }
        //output arr ={1,2,3,4,4,4}
       for(int k: arr){
        System.out.println("element = "+ k);
       }
    }
}
