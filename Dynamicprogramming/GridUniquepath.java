package Dynamicprogramming;

import java.util.Arrays;

// DP: 8----2D matrix
public class GridUniquepath {
    /**
     * Unique paths in a grid from (0,0) to (m-1,n-1)
     * @approach : top down approach with find all 
     * possible ways to reach the destination
     * @timeComplexity: O(2^(m+n)) exponential time complexity
     * * @spaceComplexity: O(m+n) for recursion stack space
     */
    static int uniquePaths(int m, int n){
        // base case, only one way to reach (0,0)
        if(m == 0 && n == 0) return 1; 
        if(m < 0 || n < 0) return 0; // out of bounds
        // move down or right
        int down = uniquePaths(m - 1, n); // move down
        int right = uniquePaths(m, n - 1); // move right
        return down + right; // total unique paths
    }
    /**
     * @approach : top down approach with memoization
     * to avoid recomputation of same subproblems
     * @timeComplexity: O(m*n) where m is number of rows and n is number of columns
     * @spaceComplexity: O(m*n) for memoization table
     * 
     */
    static int uniquePathsMemoization(int m, int n, int[][] dp){
        // base case, only one way to reach (0,0)
        if(m == 0 && n == 0) return 1; 
        if(m < 0 || n < 0) return 0; // out of bounds
        if(dp[m][n] != -1) return dp[m][n]; // check if already computed

        // move down or right
        int down = uniquePathsMemoization(m-1, n, dp); // move down
        int right = uniquePathsMemoization(m, n-1, dp); // move right
        return dp[m][n] = down + right; // total unique paths
    }
    public static void main(String[] args) {
        int m = 3; // number of rows
        int n = 7; // number of columns
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1); // initialize dp array with -1
        }
        uniquePathsMemoization(m-1, n-1, dp); // fill dp array with unique paths
        System.out.println("Unique paths from (0,0) to (" + (m-1) + "," + (n-1) + "): " + dp[m-1][n-1]);
        // System.out.println("Unique paths from (0,0) to (" + (m-1) + "," + (n-1) + "): " + uniquePathsMemoization(m-1, n-1, dp));
    }
}
