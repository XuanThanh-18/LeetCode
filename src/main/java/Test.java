import java.util.ArrayList;
import java.util.List;


class Test{
    // [ 2,3,6,7 ]
    static int [] candidates;
    static List<List<Integer>> result;
    static int target;
    public static void solve(List<Integer> path,int index,int sum){
        if(sum == target){
            result.add(new ArrayList(path));
            return;
        }
        if(sum > target) return;

        for(int num = index; num < candidates.length ; num++){
            path.add(candidates[num]);
            solve(path,num,sum + candidates[num]);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {
        candidates = new int []{2,3,6,7};
        target = 7;
        result = new ArrayList<>();
        solve(new ArrayList<>(),0,0);
        System.out.println(result);
    }
}