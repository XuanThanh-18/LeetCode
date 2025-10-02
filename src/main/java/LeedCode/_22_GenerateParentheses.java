package LeedCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _22_GenerateParentheses {
    static List<String> result = new ArrayList<String>();
    private static List<String> generateParenthesis(int n) {
        backtracking(n,0,0,new StringBuilder());
        return result;
    }

    private static  void backtracking(int n ,int open,int close,StringBuilder path) {
        if(path.length() == 2 * n ){
            result.add(new String(path));
            return;
        }
        if( open < n) {
            path.append('(');
            backtracking(n,open + 1,close,path);
            path.deleteCharAt(path.length()-1);
        }
        if(close < open){
            path.append(')');
            backtracking(n,open,close+1,path);
            path.deleteCharAt(path.length()-1);
        }
    }
    public static void main(String[] args) {
        generateParenthesis(1);
        for(String s : result){
            System.out.print(s + " ;");
        }
    }
}
