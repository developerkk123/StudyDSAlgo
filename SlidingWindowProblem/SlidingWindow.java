package SlidingWindowProblem;

public class SlidingWindow {

    // Fixed-size sliding window to find the maximum sum of subarray of size 'k'
    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;
        
        // Base case: if k is greater than n, return 0
        if (n < k) return 0;

        // Find the sum of the first 'k' elements
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        System.out.println("window sum ="+ windowSum);

        int maxSum = windowSum;

        // Slide the window from the (k+1)th element to the end of the array
        for (int i = k; i < n; i++) {
            // Update the window sum by removing the element that is left and adding the new one
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + " is: " + maxSumSubarray(arr, k));
    }
}
