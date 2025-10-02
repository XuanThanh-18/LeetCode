package LeedCode;

public class _4_MedianOfTwoStoreArrays {
    //Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n =nums1.length + nums2.length ;
        int[] merge = new int[n];
        int i=0,nums1Temp =0,nums2Temp =0;
        int m = Math.min(nums1.length , nums2.length);
        while(i<n){
            if(i<m){
                if(nums1[nums1Temp]<nums2[nums2Temp]){
                    merge[i] = nums1[nums1Temp];
                    nums1Temp++;
                }else{
                    merge[i] = nums2[nums2Temp];
                    nums2Temp++;
                }
            }else if(nums1Temp == nums1.length){
                nums1[nums1Temp] = Integer.MAX_VALUE;
            }else if(nums2Temp == nums2.length){
                nums2[nums2Temp] = Integer.MAX_VALUE;
            }
            i++;
        }
        return merge[n/2] + merge[n/2 +1];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
