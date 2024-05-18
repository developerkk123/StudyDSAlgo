package ArrayProblem;

import java.util.*;

public class UnionArrayElement {
    public static void unionArray(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        int i=0;int j=0;
        List<Integer> ls = new ArrayList<>();
        while (i < n && j < m) {
            if(nums1[i] <= nums2[j]){
                ls.add(nums1[i++]);
                while (i < n && nums1[i] == nums1[i-1]) i++;
                while(j < m && nums2[j] == nums1[i-1]) j++;
            }else{
                ls.add(nums2[j++]);
                while (j < m && nums2[j] == nums2[j-1]) j++;
                while (i < n && nums1[i] == nums2[j-1]) i++; 
            }
        }
        // add rest of nums1 element
        while(i < n){
            ls.add(nums1[i++]);
            while (i < n && nums1[i] == nums1[i-1]) i++;
        }
        // add rest of nums2 element
        while(j < m){
            ls.add(nums2[j++]);
            while (j < m && nums2[j] == nums2[j-1]) j++;
        }
        for(Integer it: ls){
            System.out.print(it+" ");
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {-8, -3, -3, -2, 0, 1, 2, 2, 6};
        int[] nums2 = {-9,-9,0};
        unionArray(nums1, nums2);
    }
}
