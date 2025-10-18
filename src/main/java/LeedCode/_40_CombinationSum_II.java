package LeedCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_CombinationSum_II {
    static int count = 0;
    static List<List<Integer>> result;
    public static void solve(int sum,List<Integer> path,int index,int[] candidates,int target){
        count++;
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        if(sum > target) return;
        for(int i = index ; i < candidates.length ; i ++){
            if(sum + candidates[i] > target) break;
            if(i > index && candidates[i] == candidates[i-1]) continue;
            path.add(candidates[i]);
            solve(sum + candidates[i],path,i+1,candidates,target);
            path.remove(path.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum2(int []candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,new ArrayList<>(),0,candidates ,target);
        return result;
    }
    public static void main(String[] args) {
        int[] candidates = new int []{10,1,2,7,6,1,5};
        int target = 8;
        combinationSum2(candidates, target);
        System.out.println(result);
        System.out.println("count:"+count);
    }
}
