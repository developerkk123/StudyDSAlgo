package Math;

public class GCD {
    public static int countMaxNumberPresent(int[] nums) {
        int max = 0;
        int count = 0;
        for(int i : nums){
            if(i > max){
                max = i;
                count=1;
            }else if(i == max){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,4,5,5,5,5};
        int x = countMaxNumberPresent(nums);
        System.out.println("x = "+ x);
    }
}
