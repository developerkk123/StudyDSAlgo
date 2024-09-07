package BitManipulation;

public class DivideTwoInteger {
    /* this method is basic
     * let n=22 and x = 3
     * check last multiple of x untill 3*count <= dividend
     * return count 
     * in this case 3*1,3*2,3*3,3*4,3*5,3*6,3*7
     */
    public static int divideNumber(int dividend, int divisor){
        int sum=0, count=0;
        while(sum+divisor <= dividend){
            count++;
            sum+=divisor;
        }
        return count;
    }
    public static void main(String[] args) {
        int dividend = 22;
        int divisor = 3;
        
        System.out.println("count = "+ divideNumber(dividend, divisor));
    }
}
