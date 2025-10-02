package LeedCode;

public class _88_MergeStortedArray_C2 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n -1;
        int point1 = m-1;
        int point2 = n-1;
        for(int i = k ; k >=0 ; k --){
            if(point2 <0){
                nums1[k] = nums1[point1];
                point1--;
            }else if(point1 < 0){
                nums1[k] = nums2[point2];
                point2--;
            }
            else if(nums1[point1] > nums2[point2]){
                nums1[k] = nums1[point1];
                point1--;
            }else{
                nums1[k] = nums2[point2];
                point2--;
            }
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
