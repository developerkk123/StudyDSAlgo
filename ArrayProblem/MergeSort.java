package ArrayProblem;
import java.util.ArrayList;

public class MergeSort {
    static void merge(int[] arr, int l, int m, int h){
        // two halves array [l,.....mid] and [mid+1,.......,h]
        int left = l;
        int right = m+1;
       ArrayList<Integer> temp = new ArrayList<>();

        while(left <= m && right <= h){
            //add first in left side if smaller element
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }
        // add remaining left element
        while(left <= m){
            temp.add(arr[left++]);
        }
        // add remaining right element
        while(right <= h){
            temp.add(arr[right++]);
        }
        //copy temp array elemtn to original array
        for(int i=l; i<=h; i++){
            arr[i] = temp.get(i-l);
        }
    }
    public static void mergeSort(int[] arr, int l, int h){
        int mid = (l+h)/2;
        if(l >= h) return;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, h);
        merge(arr, l, mid, h);
    }
    public static void main(String[] args) {
        int[] arr ={4,2,5,3,6,2,5,0,2};
        mergeSort(arr,0, arr.length-1);
        for(int x: arr){
            System.err.print(x + " ");
        }
    }
}
