package SlidingWindowProblem;
import java.util.*;

public class SlidingWindowDynamic {

    // Variable-size sliding window to find the length of the longest substring without repeating characters
    public static void lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        
        // HashMap to store the last index of each character
        HashMap<Character, Integer> charMap = new HashMap<>();
        
        // Sliding window with two pointers: 'start' and 'end'
        int start = 0;
        
        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            
            // If the character is already in the map and its index is >= start, update the start pointer
            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= start) {
                start = charMap.get(currentChar) + 1;
            }
            
            // Update the last seen index of the current character
            charMap.put(currentChar, end);
            
            // Update the maxLength if the current window size is greater
            maxLength = Math.max(maxLength, end - start + 1);
            System.out.println("start = "+ start + " end = " + end + " maxLength = "+ maxLength);
        }
       // System.out.println(maxLength);
        
       // return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcd";
        lengthOfLongestSubstring(s);
       // System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(s));
    }
}