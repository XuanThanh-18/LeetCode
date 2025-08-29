public class _88_MergeStortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int num2 :nums2){
            InsertToNums1(num2,nums1,m);
            m++;
        }
    }

    private static void InsertToNums1(int num2, int[] nums1, int m) {
        boolean isChange = false;
        for(int i=0;i<m;i++){
            if(nums1[i] > num2 ){
                isChange = true;
                for(int j = m-1;j>i;j--){
                    nums1[j+1] = nums1[j];
                }
                nums1[i] = num2;
                break;
            }
        }
        if(!isChange){
            nums1[m] = num2;
        }
    }

    public static void main(String[] args) {
        int []nums1 = {4,5,6,0,0,0};
        int []nums2 = {1,2,3};
        merge(nums1,3,nums2,3);
        for(int i = 0 ; i < nums1.length ; i++){
            System.out.print(nums1[i] + " ");
        }
    }
}
