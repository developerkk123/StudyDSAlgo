package Math;

public class PrimeCheck {
    // method 1
    // in this method which number is prime which is divisible by 1 & itself
    // means total divisor is only 2, 1 & self 
    // so run a loop and count total divisor
    // T(C) = O(n), S(c) = O(1)
    public static void isPrime(int n){
        int countDivisor=0;
        for(int i=1;i<=n;i++){
            if(n%i == 0){
                countDivisor++;
            }
        }
        if(countDivisor == 2){
            System.out.println("Yes number is prime");
        }else{
            System.out.println("no number is not prime");
        }
       
    }




// method 2
// instead of running loop till n best to check only till sqrt(n)
// for n =36 divisors = 1,2,3,4,6 and 9,12,18,36
// 1x36 = 36
// 2x18 = 36
// 3x12 = 36
// 4x9 = 36
// 6x6 = 36
//T(C)=O(root(n)) optimal approach
public static boolean isPrimeFunc(int n){
    int countDivisor = 0;
    for(int i=1; i*i <= n; i++){
        if(n%i == 0){
            countDivisor++;
            if(n%i != i){// this logic to count another divisor 2 x 18 count = 2
               // System.out.println("n = "+ n%i+" "+ i);
                countDivisor++;
            }
        }
    }
    if(countDivisor == 2){
        return true;
    }
    return false;
}
// print all prime divisor of number
// method to run loop till 1 to n and check if n%i= 0 then i is prime or not
// naive approach
// T(c) = O(n * sqrt(n))
public static void primeDivisor(int n){
    for(int i=1; i <= n; i++){
        if(n%i == 0){
            if(isPrimeFunc(i)){
                System.out.print(i +" ");
            }
        }
    }
}



// method 2 to print all prime divisor of number 
// we run loop till sqrt(n)
// let n =36
// i = 1  & n/i = 36
// i = 2  & n/i = 18
// i = 3  & n/i = 12
// i = 4  & n/i = 9
// i = 6  & n/i = 6   <===== this double count has to exclude 
// T(c) = O(sqrt(n) * 2 * sqrt(n))
public static void primeDivisorOptimal(int n){
    for(int i = 1; i*i <= n; i++){
        if(n%i == 0){
            if(isPrimeFunc(i)){
                if(n/i != i){ // line 75
                    if(isPrimeFunc(n/i)){
                        System.out.println(n/i +" ");
                    }
                }
                System.out.print(i +" ");
            }
        }
    }
}


// method 3 most optimal solution
// reduce divisor by its multiple take example 780, check 
// how many time its divide by 2 so we will not check for 4 because its multiple of 2
// if number divide by we will not check for 6,9.....
// T(c) = O(sqrt(n) * longN)
public static void primeDivisorMostOptimal(int n){
    for(int i=2; i*i <= n; i++){
        if(n%i == 0){
            if(isPrimeFunc(i)){
                System.out.print(i +" ");
            }
            while(n%i == 0){
                n = n/i;
            }
        }
    }
    if(n != 1){
        System.out.print(n+" ");
    }
}


// print all prime number till n
// method brute force
public static void printPrime(int n){
    for(int i=2; i<=n; i++){
        if(isPrimeFunc(i)){
            System.out.print(i+" ");
        }
    }
}

// optimal solution for print all prime number till n
// take array of length fill with 1
// fill zero for non prime number
// check striver video for explanation
public static void printPrimeOptimal(int n){
    int[] prime = new int[n+1];
    for(int i=0; i<=n; i++){
        prime[i] = 1;
    }
    for(int i=2; i<=n; i++){
        if(prime[i] == 1){
            for(int j = i*i; j<=n; j+= i){
                prime[j] = 0;
            }
        }
    }
    for(int i=2; i<=n;i++){
        if(prime[i] == 1){
            System.out.print(i+" ");
        }
    }
// return list of prime number
}

    public static void main(String[] args) {
        int n = 36;
        primeDivisorOptimal(n);
        // primeDivisorMostOptimal(n);
      //  System.out.println("new line");
        //int x = 20;
       // printPrime(x);
      //  printPrimeOptimal(n);
      for(int i=1; i<=20; i++){
        for(int j=i*2; j<=20; j+=i){
            System.out.print(" j = "+ j);
        }
        System.out.println("cccc");
      }
    }
}
