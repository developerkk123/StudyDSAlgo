package ArrayProblem;

public class MergeArray {
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
            }else{
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
