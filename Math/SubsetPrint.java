package Math;
import java.util.*;

public class SubsetPrint {
    public static void printAllSubset(int index, int[] nums, List<Integer> ls, List<List<Integer>> ans){
        if(index == nums.length ){
            
            if(ls.size() >0){
Collections.sort(ls);
            int min = ls.get(0);
            int max = ls.get(ls.size()-1);
            System.out.println("max = "+ max + " min = "+ min);
            }
            ans.add(new ArrayList<>(ls));
            return;
        }
        ls.add(nums[index]);
       
       
        printAllSubset(index+1, nums, ls, ans);
        ls.remove(ls.size()-1);
        // System.out.println("*****************");
        //  System.out.print(index+" ");
        printAllSubset(index+1, nums, ls, ans);
      //  System.out.println("########");
    //  System.out.print(index+ "  ");

       // printAllSubset(index+1, nums, ls, ans);
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        printAllSubset(0, nums, new ArrayList<>(), ans);
        System.out.println(ans);
    }
}
