package ArrayProblem;
import java.util.*;
public class SubArrayWithSumK {
    public static void lenOfLongSubarr (int A[], int K) {
        //Complete the function
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0;
        int maxLen=0;
        for(int i=0; i < A.length; i++){
            sum = sum + A[i];
            if(sum == K){
                 maxLen = i+1;
            }
            // calculate the sum of remaining part i.e. x-k:
            int rem = sum - K;

            //Calculate the length and update maxLen:
            if (map.containsKey(rem)) {
                System.out.println("found = "+ map.get(rem));
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!map.containsKey(sum)) {// check index 9 and 10 if we found same index at 2 index
                map.put(sum, i);
            }
        }
        System.out.println("maxLength = "+ maxLen);
      //  return maxLen;
    }
    public static void main(String[] args) {
        int[] nums = {-13,0,6,15,16,2,15,-12,17,-16,0,-3,19,-3,2,-9,-6};
        int k=15;
        lenOfLongSubarr(nums, k);
    }
}
