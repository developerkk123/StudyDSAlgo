package Dynamicprogramming;

public class Fibonacci {
    static int fibonacci(int n) {
        // Base case: if n is 0 or 1, return n
        if (n <= 1) {
            return n;
        }
        // Recursive case: return the sum of the two preceding numbers
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void main(String[] args) {
        // Example usage
        int n = 5; // Change this value to compute Fibonacci of a different number
        System.out.println("Fibonacci of " + n + ": " + fibonacci(n)); // Output: 5
    }
}
