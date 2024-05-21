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
        int[] nums = {-7, 8};
        int[] arr = {-8, -3,8};
       // int[] nums = {-37, 10,-9,15,-14,31};
       // [15,-37,14,-10,31,-9]
        // int k=0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(30, 0);
        mp.put(31,1);
        mp.put(32,2);
        mp.put(33,3);
        mp.put(34,4);
        mp.put(32,5);
        if(mp.containsKey(30)){
            System.out.println(mp.get(30));

        }
        
      //  unionArray(nums, arr);
    }
}
