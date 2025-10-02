package LeedCode;

import java.util.*;

public class _17_LetterOfCombination {
    static Map<Character,String> phoneMap = new HashMap<>();
    static{
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }
    public static  List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;
        BackTracking(result,digits,new StringBuffer(),0);
        return result;
    }

    private static void BackTracking(List<String> result,String digits,StringBuffer current,int index) {
        if(index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = phoneMap.get(digits.charAt(index));
        for(char c : letters.toCharArray()) {
            current.append(c);
            BackTracking(result,digits,current,index+1);
            current.deleteCharAt(current.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println( letterCombinations("25"));
    }
}
