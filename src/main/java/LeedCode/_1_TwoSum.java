import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {
    //    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    public static int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> map = new HashMap<>();

       for(int i=0;i<nums.length;i++){
           if(map.get(target-nums[i]) != null){
               return new int[]{map.get(target-nums[i]),i};
           }
           map.put(nums[i],i);
       }
        return new int[]{1,1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3, 4, 3, 90};
        int target = 0;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
