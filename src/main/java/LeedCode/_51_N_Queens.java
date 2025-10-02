package LeedCode;

import java.util.ArrayList;
import java.util.List;

public class _51_N_Queens {
    static boolean [] isVisited ;
    public List<List<String>> solveNQueens(int n) {
        isVisited = new boolean[n+1];
        List<List<String>> result = new ArrayList<>();
        isVisited[1] = true;
        backtracking(result,new ArrayList<>(),1,n);
        return result;
    }

    private void backtracking(List<List<String>> result,List<String> path, int row,int n) {
        if(path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        String str = "";
        for(int i = 1 ; i <= n ; i++){
            if(!isVisited[i]){
               if(checked(row,i)){
                   str += "Q";
                   isVisited[i] = true;
                   backtracking(result,path,i,n);
                   isVisited[i] = false;
               }
               else{
                   str += ".";
                   isVisited[i] = true;
                   backtracking(result,path,i,n);
                   isVisited[i] = false;
               }
            }else{
                str += ".";
                isVisited[i] = true;
                backtracking(result,path,i,n);
                isVisited[i] = false;
            }
        }
    }

    private boolean checked(int row, int i) {
        return true;
    }

    public static void main(String[] args) {

    }
}
