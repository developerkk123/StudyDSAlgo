package Dynamicprogramming;

/**
 * @DP: 3
 * @problemStatement: Frog is at 0 and want to reach n-1
 * He can jump to 1 step or 2 steps at a time find the 
 * minimum energy require to reach n-1. 
 * Each position has height and cost of jump
 * @approach: Top down approach with recursion
 * Enery cost is from index i to j abs(heights[i] - heights[j])
 * @timeComplexity: O(2^n) exponential time complexity
 * @spaceComplexity: O(n) for recursion stack space
 */
public class FrogJump {
    /**
     * @approach: Top down approach with recursion
     * Enery cost is from index i to j abs(heights[i] - heights[j])
     * @timeComplexity: O(2^n) exponential time complexity
     * @spaceComplexity: O(n) for recursion stack space
     */
    static int frogJump(int n, int[] heights) {
        // Base case: if there's only one stone, no cost to jump
        if (n == 0) return 0;
        int firstJump = frogJump(n-1, heights) + Math.abs(heights[n] - heights[n-1]);
        int secondJump = (n > 1) ? frogJump(n-2, heights) + Math.abs(heights[n] - heights[n-2]) : 0;
        return Math.min(firstJump, secondJump);
    }
    /**
     * @approach: Top down approach with memoization
     * to avoid recomputation of same subproblems
     * @timeComplexity: O(n) where n is number of stones
     * @spaceComplexity: O(n) for memoization table
     */
    static int frogJumpMemoization(int n, int[] heights, int[] dp) {
        // Base case: if there's only one stone, no cost to jump
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n]; // Check if already computed

        int firstJump = frogJumpMemoization(n-1, heights, dp) + Math.abs(heights[n] - heights[n-1]);
        int secondJump = (n > 1) ? frogJumpMemoization(n-2, heights, dp) + Math.abs(heights[n] - heights[n-2]) : Integer.MAX_VALUE;

        return dp[n] = Math.min(firstJump, secondJump);
    }
    /**
     * @approach: Bottom up approach with tabulation
     * to fill dp array with minimum cost to reach each stone
     * @timeComplexity: O(n) where n is number of stones
     * @spaceComplexity: O(n) for dp array
     */
    static int frogJumpTabulation(int n, int[] heights) {
        int[] dp = new int[n + 1];
        dp[0] = 0; // No cost to reach the first stone
        for (int i = 1; i <= n; i++) {
            int firstJump = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int secondJump = (i > 1) ? dp[i - 2] + Math.abs(heights[i] - heights[i - 2]) : Integer.MAX_VALUE;
            dp[i] = Math.min(firstJump, secondJump);
        }
        return dp[n];
    }
    /**
     * @approach: Space optimized approach
     * to reduce space complexity to O(1)
     * @timeComplexity: O(n) where n is number of stones
     * @spaceComplexity: O(1) for two variables to store previous costs
     */
    static int frogJumpSpaceOptimized(int n, int[] heights) {
        int prev1 = 0; // Cost to reach the first stone
        int prev2 = 0; // Cost to reach the second stone
        for (int i = 1; i <= n; i++) {
            int firstJump = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int secondJump = (i > 1) ? prev2 + Math.abs(heights[i] - heights[i - 2]) : Integer.MAX_VALUE;
            int currentCost = Math.min(firstJump, secondJump);
            prev2 = prev1; // Update prev2 to prev1
            prev1 = currentCost; // Update prev1 to current cost
        }
        return prev1;
    }
    public static void main(String[] args) {
        int[] heights = {10, 30, 40, 20, 50};
        System.out.print("Frog Jump Problem Solutions:\n");
        int n = heights.length;
        System.out.println("Minimum cost to reach the last stone: " + frogJump(n-1, heights));
    }
}
