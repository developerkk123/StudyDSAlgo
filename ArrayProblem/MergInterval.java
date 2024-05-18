package ArrayProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;



public class MergInterval {
    //method 1: Naive approach

    public static List<List<Integer>> mergeInterval(int[][] arr){
        //sort the given intervals:
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<arr.length-1;i++){
            
            int start = arr[i][0];
            int end = arr[i][1];
            //Skip all the merged intervals:
            // if end is less mean alreay present in existing interval
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }
            for(int j=i+1; j < arr.length; j++){
                if(arr[j][0] <= end){
                    end = Math.max(end, arr[j][1]);
                }else{
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }
   //method 2: optimal approach
   public static List<List<Integer>> mergeIntoptimal(int[][] arr){
        //sort list of array
       Arrays.sort(arr, new Comparator<int[]>() {
        public int compare(int[] a, int[] b){
            return a[0]-b[0];
        }
       });
       List<List<Integer>> res = new ArrayList<>();
       res.add(Arrays.asList(arr[0][0], arr[0][1]));
       for(int i=1;i<arr.length;i++){
        int end = arr[i][1];
        if(res.get(res.size()-i).get(1) <= end){
            res.add(Arrays.asList(res.get(res.size()-i).get(1), end));
        }
       }
     return res;
   }
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> answer = mergeIntoptimal(arr);
        for(List<Integer> ls: answer){
            System.out.print("{ "+ ls.get(0) +","+ ls.get(1)+" },");
        }

    }
}