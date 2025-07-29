package ArrayProblem;

public class MergeArray {
    /**
     * @definition: Merge two sorted arrays into a single sorted array.
     * @approach: Use two pointers to traverse both arrays and compare elements.
     * define new array result of size n1+n2 and take one pointer to track index for result array i
     * traverse through both arrays and compare elements at l and r pointers
     * whichever is lowset put in reesult array and move pointer.
     * @timeComplexity: O(n1 + n2) where n1 and n2 are the lengths of the two arrays.
     * @param arr1
     * @param arr2
     * @return
     */
    // merge two given sorted array into single array
    public static int[] mergeArrayInSortedOrder(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1+n2];
        int l = 0;
        int r =0;
        int i=0;
        while(l < n1 && r < n2){
            if(arr1[l] <= arr2[r]){
                result[i++] = arr1[l];
                l++;
            }
            else{
                result[i++]= arr2[r];
                r++;
            }
        }
        while(l < n1){
            result[i++] = arr1[l++];
        }
        while(r < n2){
            result[i++] = arr2[r++];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = {3,5,7};// first sorted array
        int[] arr2 = {-1,0,1,2,4,6};// second sorted array
        int[] res = mergeArrayInSortedOrder(arr1, arr2);
        for(int x: res){
            System.out.print(x+" ");
        }
    }
}
