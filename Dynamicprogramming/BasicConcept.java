package Dynamicprogramming;
// fibonacci(5)
// ├── fibonacci(4)
// │   ├── fibonacci(3)
// │   │   ├── fibonacci(2)
// │   │   │   ├── fibonacci(1) -> 1
// │   │   │   └── fibonacci(0) -> 0
// │   │   └── fibonacci(1) -> 1
// │   └── fibonacci(2)
// │       ├── fibonacci(1) -> 1
// │       └── fibonacci(0) -> 0
// └── fibonacci(3)
//     ├── fibonacci(2)
//     │   ├── fibonacci(1) -> 1
//     │   └── fibonacci(0) -> 0
//     └── fibonacci(1) -> 1
public class BasicConcept {
    // Dynamic programming is a method for solving complex problems by breaking them down into simpler subproblems.
    // It is applicable when the problem can be divided into overlapping subproblems that can be solved independently.
    
    // Key concepts:
    // 1. Optimal Substructure: The optimal solution to the problem can be constructed from optimal solutions of its subproblems.
    // 2. Overlapping Subproblems: The problem can be broken down into smaller subproblems which are reused multiple times.

    // Example: Fibonacci sequence
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static void main(String[] args) {
        System.out.println("Fibonacci of 5: " + fibonacci(5)); // Output: 5
    }
}
