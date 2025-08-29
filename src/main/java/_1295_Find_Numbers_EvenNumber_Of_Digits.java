public class _1295_Find_Numbers_EvenNumber_Of_Digits {
    public static int getEvenNumberOfDigits(int n){
        int cout = 0 ;
        while(n!=0){
            cout++;
            n/=10;
        }
        return cout;
    }
    public static int findNumbers(int[] nums) {
        int cout =0;
        for(Integer i : nums){
            if(getEvenNumberOfDigits(i) % 2 == 0) cout++;
        }
        return cout;
    }
    public static void main(String[] args) {
        int [] nums = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }
}
