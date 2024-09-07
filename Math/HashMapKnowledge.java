package Math;

import java.util.*;

public class HashMapKnowledge {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            }else{
                map.put(arr[i], 1);
            }
        }

        // stack to push
        HashSet<Integer> hs= new HashSet<>(map.values());
        return map.size()== hs.size();
    }
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "Apple");
        map.put("b", "Ball");
        map.put("c", "Cat");
       

        Stack<Integer> frequency = new Stack<>();
        int[] nums = {3, 2,3, 4, 2};
        int c=1;
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        // calculate prefix
        for(int i=0; i< nums.length; i++){
            if(frequency.contains(nums[i])){
                frequency.add(nums[i]);
                prefix[i] = prefix[i-1];
            }else{
                frequency.add(nums[i]);
                prefix[i] = c++;
            }
        }
        int[] arr = {1,2,2,1,1,3};
        HashMap<Integer, List<Integer>> mapp = new HashMap<>();
        for(int i=0; i< arr.length; i++){
            if(!mapp.containsKey(arr[i])){
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                mapp.put(arr[i], ls);
            }else{
                List<Integer> ls = mapp.get(arr[i]);
                ls.add(i);
                mapp.put(arr[i], ls);
            }
        }
        System.out.println(mapp);
        //output {1=[0, 3, 4], 2=[1, 2], 3=[5]}
    }
}
