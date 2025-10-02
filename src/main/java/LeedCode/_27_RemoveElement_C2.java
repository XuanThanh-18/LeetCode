package LeedCode;

public class _27_RemoveElement_C2 {
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int t = n-1;
        while( t>=0 ){
            if(nums[0] == val){
                nums[0] = nums[t];
                n--;
            }
            t--;
        }
        return n;
    }
    public static int removeElementC2(int[] nums, int val) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
    public static void main(String[] args) {
        int [] nums = {3,2,2,3};
        System.out.println(removeElementC2(nums,3));
        System.out.println("DOne");
    }
}
