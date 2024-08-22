package Math;

public class PowerExponents {
    // approach
    // if power is odd make it even like 2^11 = 2*2^10
    // if power is even make power half by squaring base 2^10 = 4^5
    public static int powerOfnumb(int x, int n){
        int ans=1;
        while(n > 0){
            if(n%2 == 1){
                ans = ans*x;
                n = n-1;
            }else{
                x = x*x;
                n = n/2;
            }
        }
        return ans;
    }

    public static long powerOfNumberMostOptimal(long x, long n){
         // use devide and conqure method
         // let we have to calculate a^b
         // c = b/2;
         // now problem become a^c * a^c in case of even , odd case  a * a^c * a^c;
        // it means x^y = x^y/2 * x^y/2 mean power reduce to half 
        // if temp = x^y/2 then in final ans just multiply temp again;
        if(n==0) return 1; // base case
        long temp = powerOfNumberMostOptimal(x, n/2);
        if(n%2 != 0){
            return temp*temp*x;
        }else{
            return temp*temp;
        }
    }
    // for negative power and decimal handling
 public static double powerOfNumberDec(double x, long n){
    double ans = 1.0;
    //if()
    // long m = Math.abs(n);
    long m = n;
    if(n<0) m = -1*m;
    while(m > 0){
        if(m%2 == 0){
            x = x*x;
            m = m/2;
        }else{
            ans = ans*x;
            m--;
        }
    }
    if(n<0){
        return (double)(1)/ (double)(ans);
    }
    return ans;
 }
    public static void main(String[] args) {
        double x = 2.00000;
        long n = -2147483648;
       double result = powerOfNumberDec(x,n);
       System.out.println("result = "+ result);
    }
}
