import java.util.*;
public class ThreeSum {
    public static void main(String[] args) {
        int[] array1=new int[]{12, 3, 1, 2, -6, 5, -8, 6};
        System.out.println("Printing solution with two pointers...");
        threeNumberSum1(array1,6).forEach(System.out::println);
        System.out.println("Printing solution with HashMap......");
        threeNumberSum2(array1,6).forEach(System.out::println);

    }
    // O(n^2) time | O(n) space
    // this is a two pointer solution, for every i,
    // running two pointer solution as in the two sum problem
    public static List<List<Integer>>  threeNumberSum1(int[] array, int targetSum){
        // Overall complexity nlogn+ n x n = n^2
        Arrays.sort(array);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<array.length-2; i++){
            //Reset pointers (left, right)
            int left = i+1;
            int right = array.length-1;
            while (left<right){
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum==targetSum){
                    list.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    right--;
                }else if(currentSum<targetSum) left++;
                else right--;
            }
        }
        return list;
    }


    // HashMap solution for 3Sum problem.
    // overall complexity is: nlogn + n + O(n^2) = O(n^2)
    public static List<List<Integer>> threeNumberSum2(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        //Put nums in hashmap for lookup table
        for(int i=0; i<nums.length; i++) map.put(nums[i], i);
        //Create nested loop with two pointers (i,j) and value target-i-j in hashmap lookup table
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                List<Integer> triplet = new ArrayList<>();
                int potentialMatch = target-nums[i]-nums[j];
                if(map.containsKey(potentialMatch) && map.get(potentialMatch)>j){
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(map.get(potentialMatch));
                    result.add(triplet);
                }
            }
        }
        return new ArrayList(result);
    }
}
