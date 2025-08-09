import java.util.HashSet;

public class _3_LongestSubstring {
//    Given a string s, find the length of the longest substring
//    without repeating characters.
    public static int lengthOfLongestSubstring(String s){
        HashSet<Character> charSet = new HashSet<>();
        int left=0,right=0,maxLength = 0;
        String longestSubString ="";
        for(right =0;right<s.length();right++){
            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left ++;
            }
            charSet.add(s.charAt(right));
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                longestSubString = s.substring(left, right + 1);  // Lưu chuỗi con mới
            }
        }
        System.out.println("Longest substring without repeating characters: " + maxLength);
        System.out.print("Characters: ");
        longestSubString.chars().forEach(ch -> System.out.print((char) ch + " "));
        System.out.println();
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "pwwkew";
        lengthOfLongestSubstring(s);
    }
}
