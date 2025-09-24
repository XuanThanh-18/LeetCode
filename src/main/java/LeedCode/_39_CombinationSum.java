package LeedCode;
import java.util.ArrayList;
import java.util.List;

public class _39_CombinationSum{
	static List<List<Integer>> result;
	static List<Integer> selected;
	static int target;
	static int []candidates;

	public static void solve(int sum,int start){
		if(sum == target){
			result.add(new ArrayList<>(selected));
			return;
		}
		if(sum > target) return;

		for(int i = start ; i < candidates.length ; i ++){
			selected.add(candidates[i]);
			solve(sum + candidates[i] , i);
			selected.remove(selected.size() - 1);
		}
	}
	public static List<List<Integer>> combinationSum() {
		result = new ArrayList<>();
        selected = new ArrayList<>();
		solve(0,0);
		return result;
    }
	public static void main(String[] args) {
		candidates = new int []{2,3,6,7};
		target = 7 ;

		result = combinationSum();
		for(List<Integer> list : result){
			for(Integer integer : list){
				System.out.print(integer+" ");
			}
			System.out.println();
		}
	}
}