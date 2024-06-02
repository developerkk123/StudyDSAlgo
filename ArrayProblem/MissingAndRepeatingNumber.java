package ArrayProblem;

public class MissingAndRepeatingNumber {
    // https://leetcode.com/problems/set-mismatch/
    public static void findMissingAndRepeating(int[] nums){
       // int[] res = new int[2];
        int[] map = new int[nums.length+1];
        for(int i=0;i < nums.length;i++){
            map[nums[i]]++;// store frequency’s 
        }
        int missing =-1;
        int duplicate =-1;
        for(int i=1; i<map.length; i++){
            if(map[i] == 2){
                duplicate = i;
            }
            if(map[i] == 0){
                missing = i;
            }
        }
        System.out.println("missing = " + missing +" duplicates = "+ duplicate);
    }
    public static void main(String[] args) {
        int[] nums = {2,3,3,4};
        findMissingAndRepeating(nums);
    }
}
